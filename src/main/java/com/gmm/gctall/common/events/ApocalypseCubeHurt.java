package com.gmm.gctall.common.events;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public final class ApocalypseCubeHurt {
  private ApocalypseCubeHurt() {
  }

  public static void run(Entity entity, World world, int x, int y, int z) {
    if (entity.world.rand.nextDouble() < 0.3D) {
      entity.attackEntityFrom(DamageSource.GENERIC, ((entity instanceof EntityLivingBase) ? ((EntityLivingBase)entity)
          .getMaxHealth() : -1.0F) / 15.0F);
      entity.setPositionAndUpdate(x + entity.world.rand.nextInt(11), y + entity.world.rand.nextInt(11), z + entity.world.rand.nextInt(11));
    }
  }
}

