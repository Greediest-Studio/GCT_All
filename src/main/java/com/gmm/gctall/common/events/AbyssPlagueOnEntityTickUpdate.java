package com.gmm.gctall.common.events;

import com.gmm.gctall.common.potions.PotionAbyssPlague;
import com.gmm.gctall.common.util.ServerCommands;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class AbyssPlagueOnEntityTickUpdate {
  private AbyssPlagueOnEntityTickUpdate() {
  }

  public static void run(World world, int x, int y, int z) {
    double timer = 0.0D;
    boolean power = false;
    BlockPos center = new BlockPos(x, y, z);
    if (Math.random() < 0.004D) {
      EntityPlayer player = EffectHelper.nearestPlayer(world, center, 32.0D);
      if (player != null)
        EffectHelper.addEffect(player, PotionAbyssPlague.potion, 200, 0, false, true);
    }
    if (Math.random() < 0.005D) {
      if (!world.isRemote && world.getMinecraftServer() != null)
        ServerCommands.run(world, x, y, z, "tellraw @a[r=10] [\"\",{\"text\":\"呜啊啊！\"}] ");
      EffectHelper.damageNearestPlayer(world, center, 10.0D, DamageSource.MAGIC, 12.0F);
    }
  }
}

