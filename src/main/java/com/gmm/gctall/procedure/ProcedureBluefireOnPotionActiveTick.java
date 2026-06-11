package com.gmm.gctall.procedure;

import java.util.Map;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;

public final class ProcedureBluefireOnPotionActiveTick {
  private ProcedureBluefireOnPotionActiveTick() {
  }

  public static void executeProcedure(Map<String, Object> dependencies) {
    if (dependencies.get("entity") == null) {
      System.err.println("Failed to load dependency entity for procedure BluefireOnPotionActiveTick!");
      return;
    }
    Entity entity = (Entity)dependencies.get("entity");
    entity.getEntityData().setDouble("counter1", entity.getEntityData().getDouble("counter1") + 1.0D);
    if (entity.getEntityData().getDouble("counter1") % 10.0D == 0.0D)
      entity.attackEntityFrom(DamageSource.MAGIC,
          (float)(((entity instanceof EntityLivingBase) ? ((EntityLivingBase)entity).getHealth() : -1.0F) * 0.2D));
  }
}

