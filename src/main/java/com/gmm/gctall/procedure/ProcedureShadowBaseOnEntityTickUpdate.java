package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.entity.EntityShadowBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class ProcedureShadowBaseOnEntityTickUpdate {
  private ProcedureShadowBaseOnEntityTickUpdate() {
  }

  public static void executeProcedure(Map<String, Object> dependencies) {
    if (dependencies.get("x") == null) {
      System.err.println("Failed to load dependency x for procedure ShadowBaseOnEntityTickUpdate!");
      return;
    }
    if (dependencies.get("y") == null) {
      System.err.println("Failed to load dependency y for procedure ShadowBaseOnEntityTickUpdate!");
      return;
    }
    if (dependencies.get("z") == null) {
      System.err.println("Failed to load dependency z for procedure ShadowBaseOnEntityTickUpdate!");
      return;
    }
    if (dependencies.get("world") == null) {
      System.err.println("Failed to load dependency world for procedure ShadowBaseOnEntityTickUpdate!");
      return;
    }
    final int x = ((Integer)dependencies.get("x")).intValue();
    final int y = ((Integer)dependencies.get("y")).intValue();
    final int z = ((Integer)dependencies.get("z")).intValue();
    final World world = (World)dependencies.get("world");
    ProcedureEffectHelper.clearPotions(EntityShadowBase.ShadowBaseEntity.class, world, new BlockPos(x, y, z), 64.0D);
  }
}

