package com.gmm.gctall.procedure;

import java.util.Collection;
import java.util.Map;
import com.gmm.gctall.potion.PotionBlueScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;

public final class ProcedureProBlueScreenTick {
  private ProcedureProBlueScreenTick() {
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

