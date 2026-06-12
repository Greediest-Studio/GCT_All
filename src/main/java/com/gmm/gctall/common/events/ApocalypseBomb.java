package com.gmm.gctall.common.events;

import net.minecraft.world.World;

public final class ApocalypseBomb {
  private ApocalypseBomb() {
  }

  public static void run(World world, int x, int y, int z) {
    if (!world.isRemote)
      world.createExplosion(null, x, y, z, 3.0F, true);
  }
}

