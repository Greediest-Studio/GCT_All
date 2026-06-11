package com.gmm.gctall.procedure;

import java.util.Map;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public final class ProcedureProAntiAnyPosionTick {
  private ProcedureProAntiAnyPosionTick() {
  }

  public static void executeProcedure(Map<String, Object> dependencies) {
    if (!ProcedureContext.require(dependencies, "ProAntiAnyPosionTick", "entity"))
      return;
    Entity entity = ProcedureContext.entity(dependencies);
    if (entity instanceof EntityLivingBase)
      ((EntityLivingBase)entity).clearActivePotions();
  }
}

