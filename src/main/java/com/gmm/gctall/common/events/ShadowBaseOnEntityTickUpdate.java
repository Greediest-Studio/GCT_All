package com.gmm.gctall.common.events;

import com.gmm.gctall.common.entity.EntityShadowBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class ShadowBaseOnEntityTickUpdate {
  private ShadowBaseOnEntityTickUpdate() {
  }

  public static void run(World world, int x, int y, int z) {
    EffectHelper.clearPotions(EntityShadowBase.ShadowBaseEntity.class, world, new BlockPos(x, y, z), 64.0D);
  }
}

