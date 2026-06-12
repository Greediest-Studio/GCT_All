package com.gmm.gctall.common.events;

import com.gmm.gctall.common.potions.PotionAbyssPlague;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;

public final class AbyssLiquidMobplayerCollidesBlock {
  private AbyssLiquidMobplayerCollidesBlock() {
  }

  public static void run(Entity entity) {
    if (entity instanceof EntityLivingBase)
      ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(PotionAbyssPlague.potion, 200, 0, false, false));
  }
}

