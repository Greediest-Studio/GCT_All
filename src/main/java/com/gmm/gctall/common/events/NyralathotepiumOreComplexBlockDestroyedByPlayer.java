package com.gmm.gctall.common.events;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;

public final class NyralathotepiumOreComplexBlockDestroyedByPlayer {
  private NyralathotepiumOreComplexBlockDestroyedByPlayer() {
  }

  public static void run(Entity entity, int x, int y, int z) {
    if (Math.random() < 0.6D &&
      entity instanceof EntityPlayer)
      ((EntityPlayer)entity).setSpawnPoint(new BlockPos((int)((x - 3) + 6.0D * Math.random()), (int)((y - 3) + 6.0D * Math.random()),
            (int)((z - 3) + 6.0D * Math.random())), true);
  }
}

