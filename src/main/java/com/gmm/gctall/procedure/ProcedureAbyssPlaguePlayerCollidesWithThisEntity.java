package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.potion.PotionAbyssPlague;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;

public final class ProcedureAbyssPlaguePlayerCollidesWithThisEntity {
  private ProcedureAbyssPlaguePlayerCollidesWithThisEntity() {
  }

  public static void executeProcedure(Map<String, Object> dependencies) {
    if (dependencies.get("entity") == null) {
      System.err.println("Failed to load dependency entity for procedure AbyssPlaguePlayerCollidesWithThisEntity!");
      return;
    }
    Entity entity = (Entity)dependencies.get("entity");
    if (entity instanceof EntityLivingBase)
      ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(PotionAbyssPlague.potion, 100, 1));
    if (entity instanceof EntityLivingBase)
      ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 100, 1));
  }
}

