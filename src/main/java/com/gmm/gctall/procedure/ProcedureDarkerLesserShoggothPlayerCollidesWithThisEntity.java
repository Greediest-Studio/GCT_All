package com.gmm.gctall.procedure;

import java.util.Map;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;

public final class ProcedureDarkerLesserShoggothPlayerCollidesWithThisEntity {
  private ProcedureDarkerLesserShoggothPlayerCollidesWithThisEntity() {
  }

  public static void executeProcedure(Map<String, Object> dependencies) {
    if (dependencies.get("entity") == null) {
      System.err.println("Failed to load dependency entity for procedure DarkerLesserShoggothPlayerCollidesWithThisEntity!");
      return;
    }
    Entity entity = (Entity)dependencies.get("entity");
    if (entity instanceof EntityLivingBase)
      ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 100, 1, false, false));
  }
}

