package com.gmm.gctall.common.events;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;

public final class ShubniggurathiumOreComplexBlockDestroyedByPlayer {
  private ShubniggurathiumOreComplexBlockDestroyedByPlayer() {
  }

  public static void run(Entity entity) {
    if (Math.random() < 0.6D &&
      entity instanceof EntityLivingBase)
      ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(MobEffects.HUNGER, 100, 9, false, false));
  }
}

