package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.potion.PotionStop;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;

@Tag
public class ProcedureYogsothothiumOreComplexBlockDestroyedByPlayer extends GctAllElement {
  public ProcedureYogsothothiumOreComplexBlockDestroyedByPlayer(GctAllContent instance) {
    super(instance, 44);
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

