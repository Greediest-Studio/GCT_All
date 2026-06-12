package com.gmm.gctall.common.events;

import com.gmm.gctall.common.blocks.BlockApocalypseAltar;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class ApocalypseHolder {
  private ApocalypseHolder() {
  }

  public static void run(Entity entity, World world, int x, int y, int z) {
    entity.world.removeEntity(entity);
    world.setBlockState(new BlockPos(x, y, z), BlockApocalypseAltar.block.getDefaultState(), 3);
  }
}

