package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.potion.PotionStop;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;

public final class ProcedureYogsothothiumOreComplexBlockDestroyedByPlayer {
  private ProcedureYogsothothiumOreComplexBlockDestroyedByPlayer() {
  }

  public static void executeProcedure(Map<String, Object> dependencies) {
    if (dependencies.get("entity") == null) {
      System.err.println("Failed to load dependency entity for procedure YogsothothiumOreComplexBlockDestroyedByPlayer!");
      return;
    }
    Entity entity = (Entity)dependencies.get("entity");
    if (Math.random() < 0.6D &&
      entity instanceof EntityLivingBase)
      ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(PotionStop.potion, 100, 0, false, false));
  }
}

