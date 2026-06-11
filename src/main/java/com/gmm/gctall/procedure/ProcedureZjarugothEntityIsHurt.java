package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.potion.PotionStop;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class ProcedureZjarugothEntityIsHurt {
  private ProcedureZjarugothEntityIsHurt() {
  }

  public static void executeProcedure(Map<String, Object> dependencies) {
    if (dependencies.get("x") == null) {
      System.err.println("Failed to load dependency x for procedure ZjarugothEntityIsHurt!");
      return;
    }
    if (dependencies.get("y") == null) {
      System.err.println("Failed to load dependency y for procedure ZjarugothEntityIsHurt!");
      return;
    }
    if (dependencies.get("z") == null) {
      System.err.println("Failed to load dependency z for procedure ZjarugothEntityIsHurt!");
      return;
    }
    if (dependencies.get("world") == null) {
      System.err.println("Failed to load dependency world for procedure ZjarugothEntityIsHurt!");
      return;
    }
    final int x = ((Integer)dependencies.get("x")).intValue();
    final int y = ((Integer)dependencies.get("y")).intValue();
    final int z = ((Integer)dependencies.get("z")).intValue();
    final World world = (World)dependencies.get("world");
    if (Math.random() < 0.02D)
      ProcedureEffectHelper.addEffectToPlayers(world, new BlockPos(x, y, z), 128.0D, PotionStop.potion, 60, 0, false, false);
  }
}

