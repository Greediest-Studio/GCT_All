package com.gmm.gctall.common.events;

import com.gmm.gctall.common.potions.PotionAbyssPlague;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;

public final class AbyssPlaguePlayerCollidesWithThisEntity {
  private AbyssPlaguePlayerCollidesWithThisEntity() {
  }

  public static void run(Entity entity) {
    if (entity instanceof EntityLivingBase)
      ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(PotionAbyssPlague.potion, 100, 1));
    if (entity instanceof EntityLivingBase)
      ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 100, 1));
  }
}

