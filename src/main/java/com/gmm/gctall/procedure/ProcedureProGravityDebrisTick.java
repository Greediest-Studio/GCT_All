package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.block.BlockGravityDebris;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class ProcedureProGravityDebrisTick {
  private ProcedureProGravityDebrisTick() {
  }

  public static void executeProcedure(Map<String, Object> dependencies) {
    if (!ProcedureContext.require(dependencies, "ProGravityDebrisTick", "x", "y", "z", "world"))
      return;
    int x = ProcedureContext.x(dependencies);
    int y = ProcedureContext.y(dependencies);
    int z = ProcedureContext.z(dependencies);
    World world = ProcedureContext.world(dependencies);
    if (world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock())
      if (y == 255) {
        world.setBlockToAir(new BlockPos(x, y, z));
      } else {
        world.setBlockToAir(new BlockPos(x, y, z));
        world.setBlockState(new BlockPos(x, y + 1, z), BlockGravityDebris.block.getDefaultState(), 3);
      }
  }
}

