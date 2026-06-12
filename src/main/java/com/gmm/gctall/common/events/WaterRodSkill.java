package com.gmm.gctall.common.events;

import com.gmm.gctall.common.util.ServerCommandHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public final class WaterRodSkill {
  private WaterRodSkill() {
  }

  public static void run(Entity entity, World world, int x, int y, int z) {
    ServerCommandHelper.run(world, x, y, z, "fill ~1 ~ ~1 ~-1 ~16 ~-1 air");
    if (world.rand.nextDouble() < 0.001D &&
      entity instanceof EntityLivingBase)
      ((EntityLivingBase)entity).setHealth(0.0F);
  }
}

