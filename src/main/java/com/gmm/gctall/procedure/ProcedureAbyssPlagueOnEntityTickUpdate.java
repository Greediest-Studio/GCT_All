package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.potion.PotionAbyssPlague;
import com.gmm.gctall.util.ServerCommands;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class ProcedureAbyssPlagueOnEntityTickUpdate {
  private ProcedureAbyssPlagueOnEntityTickUpdate() {
  }

  public static void executeProcedure(Map<String, Object> dependencies) {
    if (dependencies.get("x") == null) {
      System.err.println("Failed to load dependency x for procedure AbyssPlagueOnEntityTickUpdate!");
      return;
    }
    if (dependencies.get("y") == null) {
      System.err.println("Failed to load dependency y for procedure AbyssPlagueOnEntityTickUpdate!");
      return;
    }
    if (dependencies.get("z") == null) {
      System.err.println("Failed to load dependency z for procedure AbyssPlagueOnEntityTickUpdate!");
      return;
    }
    if (dependencies.get("world") == null) {
      System.err.println("Failed to load dependency world for procedure AbyssPlagueOnEntityTickUpdate!");
      return;
    }
    final int x = ((Integer)dependencies.get("x")).intValue();
    final int y = ((Integer)dependencies.get("y")).intValue();
    final int z = ((Integer)dependencies.get("z")).intValue();
    final World world = (World)dependencies.get("world");
    double timer = 0.0D;
    boolean power = false;
    BlockPos center = new BlockPos(x, y, z);
    if (Math.random() < 0.004D) {
      EntityPlayer player = ProcedureEffectHelper.nearestPlayer(world, center, 32.0D);
      if (player != null)
        ProcedureEffectHelper.addEffect(player, PotionAbyssPlague.potion, 200, 0, false, true);
    }
    if (Math.random() < 0.005D) {
      if (!world.isRemote && world.getMinecraftServer() != null)
        ServerCommands.run(world, x, y, z, "tellraw @a[r=10] [\"\",{\"text\":\"呜啊啊！\"}] ");
      ProcedureEffectHelper.damageNearestPlayer(world, center, 10.0D, DamageSource.MAGIC, 12.0F);
    }
  }
}

