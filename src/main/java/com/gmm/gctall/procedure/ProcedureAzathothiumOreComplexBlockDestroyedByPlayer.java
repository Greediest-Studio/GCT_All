package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.potion.PotionAbyssPlague;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;

public final class ProcedureAzathothiumOreComplexBlockDestroyedByPlayer {
  private ProcedureAzathothiumOreComplexBlockDestroyedByPlayer() {
  }

  public static void executeProcedure(Map<String, Object> dependencies) {
    if (dependencies.get("entity") == null) {
      System.err.println("Failed to load dependency entity for procedure AzathothiumOreComplexBlockDestroyedByPlayer!");
      return;
    }
    Entity entity = (Entity)dependencies.get("entity");
    if (Math.random() < 0.6D &&
      entity instanceof EntityLivingBase)
      ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(PotionAbyssPlague.potion, 100, 0, false, false));
  }
}

