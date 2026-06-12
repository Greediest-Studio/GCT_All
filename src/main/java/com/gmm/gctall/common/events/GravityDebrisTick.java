package com.gmm.gctall.common.events;

import com.gmm.gctall.common.blocks.BlockGravityDebris;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class GravityDebrisTick {
  private GravityDebrisTick() {
  }

  public static void run(World world, int x, int y, int z) {
    if (world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock())
      if (y == 255) {
        world.setBlockToAir(new BlockPos(x, y, z));
      } else {
        world.setBlockToAir(new BlockPos(x, y, z));
        world.setBlockState(new BlockPos(x, y + 1, z), BlockGravityDebris.block.getDefaultState(), 3);
      }
  }
}

