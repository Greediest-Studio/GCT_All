package com.gmm.gctall.procedure;

import java.util.Map;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.world.World;

public final class ProcedureProChannelingTick {
  private ProcedureProChannelingTick() {
  }

  public static void executeProcedure(Map<String, Object> dependencies) {
    if (!ProcedureContext.require(dependencies, "ProChannelingTick", "x", "y", "z", "world"))
      return;
    int x = ProcedureContext.x(dependencies);
    int y = ProcedureContext.y(dependencies);
    int z = ProcedureContext.z(dependencies);
    World world = ProcedureContext.world(dependencies);
    if (world.rand.nextDouble() < 0.05D)
      world.addWeatherEffect((Entity)new EntityLightningBolt(world, x, y, z, false));
  }
}

