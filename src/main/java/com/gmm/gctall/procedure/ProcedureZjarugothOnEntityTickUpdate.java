package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.potion.PotionZjarugothDamage;
import com.gmm.gctall.util.ServerCommands;
import com.gmm.gctall.block.BlockBlueFire;
import com.gmm.gctall.entity.EntityZjarugoth;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class ProcedureZjarugothOnEntityTickUpdate {
  private ProcedureZjarugothOnEntityTickUpdate() {
  }

  public static void executeProcedure(Map<String, Object> dependencies) {
    if (dependencies.get("x") == null) {
      System.err.println("Failed to load dependency x for procedure ZjarugothOnEntityTickUpdate!");
      return;
    }
    if (dependencies.get("y") == null) {
      System.err.println("Failed to load dependency y for procedure ZjarugothOnEntityTickUpdate!");
      return;
    }
    if (dependencies.get("z") == null) {
      System.err.println("Failed to load dependency z for procedure ZjarugothOnEntityTickUpdate!");
      return;
    }
    if (dependencies.get("world") == null) {
      System.err.println("Failed to load dependency world for procedure ZjarugothOnEntityTickUpdate!");
      return;
    }
    final int x = ((Integer)dependencies.get("x")).intValue();
    final int y = ((Integer)dependencies.get("y")).intValue();
    final int z = ((Integer)dependencies.get("z")).intValue();
    final World world = (World)dependencies.get("world");
    BlockPos center = new BlockPos(x, y, z);
    ProcedureEffectHelper.clearPotions(EntityZjarugoth.ZjarugothEntity.class, world, center, 10.0D);
    if (Math.random() < 0.005D &&
      !world.isRemote && world.getMinecraftServer() != null)
      ServerCommands.run(world, x, y, z, "tellraw @a[r=64] [\"\",{\"text\":\"<Zjarugoth>哈，你似乎认为我比扎哈尔那家伙弱？\"}]");
    if (Math.random() < 0.008D) {
      if (!world.isRemote && world.getMinecraftServer() != null)
        ServerCommands.run(world, x, y, z, "tellraw @a[r=64] [\"\",{\"text\":\"<Zjarugoth>Ymg' uaaah ya lloigazath!\"}]");
      if (Math.random() < 0.25D) {
        if (!world.isRemote)
          world.createExplosion(null, (int)(x + 6.0D + Math.random() * 10.0D), (int)((y - 5) + Math.random() * 10.0D),
              (int)(z + 6.0D + Math.random() * 10.0D), 4.0F, true);
      } else if (Math.random() < 0.33D) {
        if (!world.isRemote)
          world.createExplosion(null, (int)(x - 6.0D + Math.random() * 10.0D), (int)((y - 5) + Math.random() * 10.0D),
              (int)(z + 6.0D + Math.random() * 10.0D), 4.0F, true);
      } else if (Math.random() < 0.5D) {
        if (!world.isRemote)
          world.createExplosion(null, (int)(x - 6.0D + Math.random() * 10.0D), (int)((y - 5) + Math.random() * 10.0D),
              (int)(z - 6.0D + Math.random() * 10.0D), 4.0F, true);
      } else if (!world.isRemote) {
        world.createExplosion(null, (int)(x + 6.0D + Math.random() * 10.0D), (int)((y - 5) + Math.random() * 10.0D),
            (int)(z - 6.0D + Math.random() * 10.0D), 4.0F, true);
      }
    }
    if (Math.random() < 0.008D) {
      if (!world.isRemote && world.getMinecraftServer() != null)
        ServerCommands.run(world, x, y, z, "tellraw @a[r=64] [\"\",{\"text\":\"<Zjarugoth>Ymg' uaaah ya lloigazath!\"}]");
      ProcedureEffectHelper.addEffectToPlayers(world, center, 64.0D, PotionZjarugothDamage.potion, 1, 0, false, false);
      world.playSound((EntityPlayer)null, x, y, z, (SoundEvent)SoundEvent.REGISTRY
          .getObject(new ResourceLocation("gct_all:zjarugoth_roar")), SoundCategory.NEUTRAL, 4.0F, 1.0F);
    }
    if (Math.random() < 0.002D) {
      if (!world.isRemote && world.getMinecraftServer() != null)
        ServerCommands.run(world, x, y, z, "tellraw @a[r=64] [\"\",{\"text\":\"<Zjarugoth>Fm'latghor, fm'latgh!\"}]");
      world.setBlockState(new BlockPos(x + 3, y + 6, z + 0), BlockBlueFire.block.getDefaultState(), 3);
      world.setBlockState(new BlockPos(x + 3, y + 6, z + 1), BlockBlueFire.block.getDefaultState(), 3);
      world.setBlockState(new BlockPos(x + 3, y + 6, z - 1), BlockBlueFire.block.getDefaultState(), 3);
      world.setBlockState(new BlockPos(x - 3, y + 6, z + 0), BlockBlueFire.block.getDefaultState(), 3);
      world.setBlockState(new BlockPos(x - 3, y + 6, z + 1), BlockBlueFire.block.getDefaultState(), 3);
      world.setBlockState(new BlockPos(x - 3, y + 6, z - 1), BlockBlueFire.block.getDefaultState(), 3);
      world.setBlockState(new BlockPos(x + 0, y + 6, z + 3), BlockBlueFire.block.getDefaultState(), 3);
      world.setBlockState(new BlockPos(x + 1, y + 6, z + 3), BlockBlueFire.block.getDefaultState(), 3);
      world.setBlockState(new BlockPos(x - 1, y + 6, z + 3), BlockBlueFire.block.getDefaultState(), 3);
      world.setBlockState(new BlockPos(x + 0, y + 6, z - 3), BlockBlueFire.block.getDefaultState(), 3);
      world.setBlockState(new BlockPos(x + 1, y + 6, z - 3), BlockBlueFire.block.getDefaultState(), 3);
      world.setBlockState(new BlockPos(x - 1, y + 6, z - 3), BlockBlueFire.block.getDefaultState(), 3);
      world.setBlockState(new BlockPos(x + 2, y + 6, z + 2), BlockBlueFire.block.getDefaultState(), 3);
      world.setBlockState(new BlockPos(x - 2, y + 6, z + 2), BlockBlueFire.block.getDefaultState(), 3);
      world.setBlockState(new BlockPos(x + 2, y + 6, z - 2), BlockBlueFire.block.getDefaultState(), 3);
      world.setBlockState(new BlockPos(x - 2, y + 6, z - 2), BlockBlueFire.block.getDefaultState(), 3);
    }
  }
}

