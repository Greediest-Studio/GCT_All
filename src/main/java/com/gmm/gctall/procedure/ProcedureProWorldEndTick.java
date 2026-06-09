package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

@Tag
public class ProcedureProWorldEndTick extends GctAllElement {
  private static final Potion[] BUFFS = {
      MobEffects.SPEED,
      MobEffects.HASTE,
      MobEffects.STRENGTH,
      MobEffects.JUMP_BOOST,
      MobEffects.REGENERATION,
      MobEffects.RESISTANCE,
      MobEffects.FIRE_RESISTANCE,
      MobEffects.HEALTH_BOOST
  };

  public ProcedureProWorldEndTick(GctAllContent instance) {
    super(instance, 135);
  }
  
  public static void executeProcedure(Map<String, Object> dependencies) {
    if (!ProcedureContext.require(dependencies, "ProWorldEndTick", "entity"))
      return;
    Entity entity = ProcedureContext.entity(dependencies);
    if (!(entity instanceof EntityLivingBase))
      return; 
    EntityLivingBase living = (EntityLivingBase)entity;
    for (Potion potion : BUFFS) {
      PotionEffect current = living.getActivePotionEffect(potion);
      if (current == null || current.getDuration() <= 2)
        living.addPotionEffect(new PotionEffect(potion, 5, 255, false, false)); 
    }
  }
}

