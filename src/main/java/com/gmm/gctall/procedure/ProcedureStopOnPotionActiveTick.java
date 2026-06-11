package com.gmm.gctall.procedure;

import java.util.Map;
import net.minecraft.entity.Entity;

public final class ProcedureStopOnPotionActiveTick {
  private ProcedureStopOnPotionActiveTick() {
  }

  public static void executeProcedure(Map<String, Object> dependencies) {
    if (dependencies.get("entity") == null) {
      System.err.println("Failed to load dependency entity for procedure StopOnPotionActiveTick!");
      return;
    }
    if (dependencies.get("x") == null) {
      System.err.println("Failed to load dependency x for procedure StopOnPotionActiveTick!");
      return;
    }
    if (dependencies.get("y") == null) {
      System.err.println("Failed to load dependency y for procedure StopOnPotionActiveTick!");
      return;
    }
    if (dependencies.get("z") == null) {
      System.err.println("Failed to load dependency z for procedure StopOnPotionActiveTick!");
      return;
    }
    Entity entity = (Entity)dependencies.get("entity");
    int x = ((Integer)dependencies.get("x")).intValue();
    int y = ((Integer)dependencies.get("y")).intValue();
    int z = ((Integer)dependencies.get("z")).intValue();
    entity.setPositionAndUpdate(x, y, z);
  }
}

