package com.gmm.gctall.procedure;

import java.util.Map;
import net.minecraft.world.World;

public final class ProcedureProApocalypseBomb {
  private ProcedureProApocalypseBomb() {
  }

  public static void executeProcedure(Map<String, Object> dependencies) {
    if (!ProcedureContext.require(dependencies, "ProApocalypseBomb", "x", "y", "z", "world"))
      return;
    int x = ProcedureContext.x(dependencies);
    int y = ProcedureContext.y(dependencies);
    int z = ProcedureContext.z(dependencies);
    World world = ProcedureContext.world(dependencies);
    if (!world.isRemote)
      world.createExplosion(null, x, y, z, 3.0F, true);
  }
}

