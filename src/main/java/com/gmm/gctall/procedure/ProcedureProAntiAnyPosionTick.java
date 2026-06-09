package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

@Tag
public class ProcedureProAntiAnyPosionTick extends GctAllElement {
  public ProcedureProAntiAnyPosionTick(GctAllContent instance) {
    super(instance, 133);
  }
  
  public static void executeProcedure(Map<String, Object> dependencies) {
    if (!ProcedureContext.require(dependencies, "ProAntiAnyPosionTick", "entity"))
      return;
    Entity entity = ProcedureContext.entity(dependencies);
    if (entity instanceof EntityLivingBase)
      ((EntityLivingBase)entity).clearActivePotions(); 
  }
}

