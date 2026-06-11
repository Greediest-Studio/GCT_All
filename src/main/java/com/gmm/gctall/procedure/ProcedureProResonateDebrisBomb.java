package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.block.BlockResonateDebrisCracked;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class ProcedureProResonateDebrisBomb {
  private ProcedureProResonateDebrisBomb() {
  }

  public static void executeProcedure(Map<String, Object> dependencies) {
    if (!ProcedureContext.require(dependencies, "ProResonateDebrisBomb", "x", "y", "z", "world"))
      return;
    int x = ProcedureContext.x(dependencies);
    int y = ProcedureContext.y(dependencies);
    int z = ProcedureContext.z(dependencies);
    World world = ProcedureContext.world(dependencies);
    world.setBlockState(new BlockPos(x, y, z), BlockResonateDebrisCracked.block.getDefaultState(), 3);
  }
}

