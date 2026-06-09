package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

@Tag
public class ProcedureZjarugothDamagePotionStartedapplied extends GctAllElement {
  public ProcedureZjarugothDamagePotionStartedapplied(GctAllContent instance) {
    super(instance, 78);
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

