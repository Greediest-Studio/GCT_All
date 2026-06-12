package com.gmm.gctall.common.events;

import com.gmm.gctall.common.potions.PotionAbyssPlague;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;

public final class AzathothiumOreComplexBlockDestroyedByPlayer {
  private AzathothiumOreComplexBlockDestroyedByPlayer() {
  }

  public static void run(Entity entity) {
    if (Math.random() < 0.6D &&
      entity instanceof EntityLivingBase)
      ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(PotionAbyssPlague.potion, 100, 0, false, false));
  }
}

