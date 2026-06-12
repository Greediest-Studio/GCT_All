package com.gmm.gctall.common.events;

import com.gmm.gctall.common.entity.EntityApocalypseCube;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class ApocalypseKnightSkill {
  private ApocalypseKnightSkill() {
  }

  public static void run(World world, int x, int y, int z) {
    if (world.rand.nextDouble() < 0.01D)
      for (EntityApocalypseCube.ApocalypseCubeEntity cube : EffectHelper.livingWithin(EntityApocalypseCube.ApocalypseCubeEntity.class, world, new BlockPos(x, y, z), 16.0D))
        cube.setHealth(Math.min(cube.getMaxHealth(), cube.getHealth() + 32.0F));
  }
}

