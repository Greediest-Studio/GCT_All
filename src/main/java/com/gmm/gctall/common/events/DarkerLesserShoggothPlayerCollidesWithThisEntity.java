package com.gmm.gctall.common.events;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;

public final class DarkerLesserShoggothPlayerCollidesWithThisEntity {
  private DarkerLesserShoggothPlayerCollidesWithThisEntity() {
  }

  public static void run(Entity entity) {
    if (entity instanceof EntityLivingBase)
      ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 100, 1, false, false));
  }
}

