package com.gmm.gctall.procedure;

import java.util.Map;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;

public final class ProcedureProCurseOfTwilightTick {
  private ProcedureProCurseOfTwilightTick() {
  }

  public static void executeProcedure(Map<String, Object> dependencies) {
    if (!ProcedureContext.require(dependencies, "ProCurseOfTwilightTick", "entity"))
      return;
    Entity entity = ProcedureContext.entity(dependencies);
    if (entity.world.rand.nextDouble() < 0.5D)
      entity.attackEntityFrom(DamageSource.GENERIC, ((entity instanceof EntityLivingBase) ? ((EntityLivingBase)entity)
          .getMaxHealth() : -1.0F) / (20 + entity.world.rand.nextInt(11)));
  }
}

