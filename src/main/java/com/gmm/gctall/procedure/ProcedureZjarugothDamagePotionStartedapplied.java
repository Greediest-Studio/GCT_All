package com.gmm.gctall.procedure;

import java.util.Map;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public final class ProcedureZjarugothDamagePotionStartedapplied {
  private ProcedureZjarugothDamagePotionStartedapplied() {
  }

  public static void executeProcedure(Map<String, Object> dependencies) {
    if (dependencies.get("entity") == null) {
      System.err.println("Failed to load dependency entity for procedure ZjarugothDamagePotionStartedapplied!");
      return;
    }
    Entity entity = (Entity)dependencies.get("entity");
    if (entity instanceof EntityLivingBase)
      ((EntityLivingBase)entity)
        .setHealth(((entity instanceof EntityLivingBase) ? ((EntityLivingBase)entity).getHealth() : -1.0F) - 10.0F);
  }
}

