package com.gmm.gctall.common.events;

import com.gmm.gctall.common.potions.PotionStop;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;

public final class YogsothothiumOreComplexBlockDestroyedByPlayer {
  private YogsothothiumOreComplexBlockDestroyedByPlayer() {
  }

  public static void run(Entity entity) {
    if (Math.random() < 0.6D &&
      entity instanceof EntityLivingBase)
      ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(PotionStop.potion, 100, 0, false, false));
  }
}

