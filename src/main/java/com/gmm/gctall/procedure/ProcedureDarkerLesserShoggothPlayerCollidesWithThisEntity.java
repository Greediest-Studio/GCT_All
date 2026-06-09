package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;

@Tag
public class ProcedureDarkerLesserShoggothPlayerCollidesWithThisEntity extends GctAllElement {
  public ProcedureDarkerLesserShoggothPlayerCollidesWithThisEntity(GctAllContent instance) {
    super(instance, 6);
  }
  
  public static void executeProcedure(Map<String, Object> dependencies) {
    if (dependencies.get("entity") == null) {
      System.err.println("Failed to load dependency entity for procedure DarkerLesserShoggothPlayerCollidesWithThisEntity!");
      return;
    } 
    Entity entity = (Entity)dependencies.get("entity");
    if (entity instanceof EntityLivingBase)
      ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 100, 1, false, false)); 
  }
}

