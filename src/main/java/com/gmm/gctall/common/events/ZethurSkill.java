package com.gmm.gctall.common.events;

import com.gmm.gctall.common.potions.PotionChanneling;
import com.gmm.gctall.common.util.ServerCommandHelper;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public final class ZethurSkill {
  private static final float ZETHUR_FALL_DAMAGE_DISTANCE = 13.0F;
  private static final double RANDOM_TELEPORT_RADIUS = 50.0D;
  private static final int RANDOM_TELEPORT_ATTEMPTS = 96;

  private ZethurSkill() {
  }

  public static void run(World world, int x, int y, int z) {
    ServerCommandHelper.run(world, x, y, z, "weather thunder");
    BlockPos center = new BlockPos(x, y, z);
    EffectHelper.applyToEntities(Entity.class, world, center, 64.0D, nearby -> {
      ResourceLocation name = EntityList.getKey(nearby);
      if (name != null && "aether_legacy".equals(name.getNamespace()) && "zephyr".equals(name.getPath()) && nearby instanceof EntityLivingBase) {
        EntityLivingBase living = (EntityLivingBase)nearby;
        living.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 300, 2));
        living.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 300, 0));
      }
    });
    if (world.rand.nextDouble() < 0.003D)
      teleportPlayersToGroundBelow(world, center, 16.0D);
    if (world.rand.nextDouble() < 0.02D)
      teleportPlayersToGroundBelow(world, center, 4.0D);
    if (world.rand.nextDouble() < 0.001D)
      EffectHelper.addEffectToPlayers(world, center, 64.0D, PotionChanneling.potion, 200, 0, false, true);
    if (world.rand.nextDouble() < 5.0E-4D) {
      ServerCommandHelper.run(world, x, y, z, "summon aether_legacy:zephyr ~ ~-3 ~");
      ServerCommandHelper.run(world, x, y, z, "summon aether_legacy:zephyr ~5 ~ ~");
      ServerCommandHelper.run(world, x, y, z, "summon aether_legacy:zephyr ~-5 ~ ~");
    }
  }

  private static void teleportPlayersToGroundBelow(World world, BlockPos center, double triggerRadius) {
    if (world == null || world.isRemote)
      return;
    for (EntityPlayer player : EffectHelper.playersWithin(world, center, triggerRadius)) {
      BlockPos destination = findGroundBelow(world, player);
      double targetX = player.posX;
      double targetZ = player.posZ;
      if (destination == null) {
        destination = findRandomGround(world, center, triggerRadius, player.posY);
        if (destination != null) {
          targetX = destination.getX() + 0.5D;
          targetZ = destination.getZ() + 0.5D;
        }
      }
      if (destination != null)
        teleportWithFallDamage(player, destination, targetX, targetZ);
    }
  }

  private static void teleportWithFallDamage(EntityPlayer player, BlockPos destination, double targetX, double targetZ) {
    player.setPositionAndUpdate(targetX, destination.getY(), targetZ);
    player.fall(ZETHUR_FALL_DAMAGE_DISTANCE, 1.0F);
  }

  private static BlockPos findGroundBelow(World world, EntityPlayer player) {
    int x = MathHelper.floor(player.posX);
    int z = MathHelper.floor(player.posZ);
    int startY = Math.min(world.getHeight() - 2, MathHelper.floor(player.posY) - 1);
    for (int groundY = startY; groundY >= 0; groundY--) {
      BlockPos feet = new BlockPos(x, groundY + 1, z);
      if (canStandAt(world, feet))
        return feet;
    }
    return null;
  }

  private static BlockPos findRandomGround(World world, BlockPos center, double triggerRadius, double maxY) {
    double minDistanceSq = triggerRadius * triggerRadius;
    double maxDistanceSq = RANDOM_TELEPORT_RADIUS * RANDOM_TELEPORT_RADIUS;
    int highestY = Math.min(world.getHeight() - 2, MathHelper.floor(maxY));
    for (int attempt = 0; attempt < RANDOM_TELEPORT_ATTEMPTS; attempt++) {
      double offsetX = (world.rand.nextDouble() * 2.0D - 1.0D) * RANDOM_TELEPORT_RADIUS;
      double offsetZ = (world.rand.nextDouble() * 2.0D - 1.0D) * RANDOM_TELEPORT_RADIUS;
      double distanceSq = offsetX * offsetX + offsetZ * offsetZ;
      if (distanceSq > maxDistanceSq || distanceSq <= minDistanceSq)
        continue;
      int x = center.getX() + MathHelper.floor(offsetX);
      int z = center.getZ() + MathHelper.floor(offsetZ);
      double finalOffsetX = x + 0.5D - (center.getX() + 0.5D);
      double finalOffsetZ = z + 0.5D - (center.getZ() + 0.5D);
      double finalDistanceSq = finalOffsetX * finalOffsetX + finalOffsetZ * finalOffsetZ;
      if (finalDistanceSq > maxDistanceSq || finalDistanceSq <= minDistanceSq)
        continue;
      for (int groundY = highestY - 1; groundY >= 0; groundY--) {
        BlockPos feet = new BlockPos(x, groundY + 1, z);
        if (canStandAt(world, feet))
          return feet;
      }
    }
    return null;
  }

  private static boolean canStandAt(World world, BlockPos feet) {
    BlockPos ground = feet.down();
    IBlockState groundState = world.getBlockState(ground);
    return isClear(world, feet)
        && isClear(world, feet.up())
        && groundState.getMaterial().blocksMovement()
        && groundState.isSideSolid(world, ground, EnumFacing.UP);
  }

  private static boolean isClear(World world, BlockPos pos) {
    return !world.getBlockState(pos).getMaterial().blocksMovement();
  }
}

