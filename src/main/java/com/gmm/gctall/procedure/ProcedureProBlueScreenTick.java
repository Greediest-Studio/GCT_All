package com.gmm.gctall.procedure;

import java.util.Collection;
import java.util.Map;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.potion.PotionBlueScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;

@Tag
public class ProcedureProBlueScreenTick extends GctAllElement {
  public ProcedureProBlueScreenTick(GctAllContent instance) {
    super(instance, 131);
  }
  
  public static boolean executeProcedure(Map<String, Object> dependencies) {
    if (!ProcedureContext.require(dependencies, "ProBlueScreenTick", "entity"))
      return false;
    final Entity entity = ProcedureContext.entity(dependencies);
    if ((new Object() {
        boolean check() {
          if (entity instanceof EntityLivingBase) {
            Collection<PotionEffect> effects = ((EntityLivingBase)entity).getActivePotionEffects();
            for (PotionEffect effect : effects) {
              if (effect.getPotion() == PotionBlueScreen.potion)
                return true; 
            } 
          } 
          return false;
        }
      }).check())
      return true; 
    return false;
  }
}

