package com.gmm.gctall.procedure;

import java.util.Map;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;

public final class ProcedureShubniggurathiumOreComplexBlockDestroyedByPlayer {
  private ProcedureShubniggurathiumOreComplexBlockDestroyedByPlayer() {
  }

  public static void executeProcedure(Map<String, Object> dependencies) {
    if (dependencies.get("entity") == null) {
      System.err.println("Failed to load dependency entity for procedure ShubniggurathiumOreComplexBlockDestroyedByPlayer!");
      return;
    }
    Entity entity = (Entity)dependencies.get("entity");
    if (Math.random() < 0.6D &&
      entity instanceof EntityLivingBase)
      ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(MobEffects.HUNGER, 100, 9, false, false));
  }
}

