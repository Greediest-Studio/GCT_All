package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.block.BlockBesideVoidPortal2;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class ProcedureProBesideVoidPortalDown {
  private ProcedureProBesideVoidPortalDown() {
  }

  public static void executeProcedure(Map<String, Object> dependencies) {
    if (!ProcedureContext.require(dependencies, "ProBesideVoidPortalDown", "x", "y", "z", "world"))
      return;
    int x = ProcedureContext.x(dependencies);
    int y = ProcedureContext.y(dependencies);
    int z = ProcedureContext.z(dependencies);
    World world = ProcedureContext.world(dependencies);
    if (world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() != BlockBesideVoidPortal2.block.getDefaultState()
      .getBlock())
      world.setBlockState(new BlockPos(x, y, z), Blocks.AIR.getDefaultState(), 3);
  }
}

