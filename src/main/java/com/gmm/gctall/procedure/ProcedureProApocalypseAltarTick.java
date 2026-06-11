package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.block.BlockApocalypseAltarBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class ProcedureProApocalypseAltarTick {
  private ProcedureProApocalypseAltarTick() {
  }

  public static void executeProcedure(Map<String, Object> dependencies) {
    if (!ProcedureContext.require(dependencies, "ProApocalypseAltarTick", "x", "y", "z", "world"))
      return;
    int x = ProcedureContext.x(dependencies);
    int y = ProcedureContext.y(dependencies);
    int z = ProcedureContext.z(dependencies);
    World world = ProcedureContext.world(dependencies);
    if (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock())
      world.setBlockState(new BlockPos(x, y - 1, z), BlockApocalypseAltarBase.block.getDefaultState(), 3);
  }
}

