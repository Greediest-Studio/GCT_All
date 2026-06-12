package com.gmm.gctall.common.events;

import com.gmm.gctall.common.potions.PotionStop;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class ZjarugothEntityIsHurt {
  private ZjarugothEntityIsHurt() {
  }

  public static void run(World world, int x, int y, int z) {
    if (Math.random() < 0.02D)
      EffectHelper.addEffectToPlayers(world, new BlockPos(x, y, z), 128.0D, PotionStop.potion, 60, 0, false, false);
  }
}

