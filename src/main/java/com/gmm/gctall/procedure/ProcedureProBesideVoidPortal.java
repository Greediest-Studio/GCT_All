package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.block.BlockBesideVoidPortal1;
import com.gmm.gctall.block.BlockBesideVoidPortal3;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class ProcedureProBesideVoidPortal {
  private ProcedureProBesideVoidPortal() {
  }

  public static void executeProcedure(Map<String, Object> dependencies) {
    if (!ProcedureContext.require(dependencies, "ProBesideVoidPortal", "x", "y", "z", "world"))
      return;
    int x = ProcedureContext.x(dependencies);
    int y = ProcedureContext.y(dependencies);
    int z = ProcedureContext.z(dependencies);
    World world = ProcedureContext.world(dependencies);
    if (world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock())
      world.setBlockState(new BlockPos(x, y + 1, z), BlockBesideVoidPortal1.block.getDefaultState(), 3);
    if (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock())
      world.setBlockState(new BlockPos(x, y - 1, z), BlockBesideVoidPortal3.block.getDefaultState(), 3);
  }
}

