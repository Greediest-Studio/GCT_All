package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.potion.PotionAbyssPlague;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;

public final class ProcedureAbyssLiquidMobplayerCollidesBlock {
  private ProcedureAbyssLiquidMobplayerCollidesBlock() {
  }

  public static void executeProcedure(Map<String, Object> dependencies) {
    if (dependencies.get("entity") == null) {
      System.err.println("Failed to load dependency entity for procedure AbyssLiquidMobplayerCollidesBlock!");
      return;
    }
    Entity entity = (Entity)dependencies.get("entity");
    if (entity instanceof EntityLivingBase)
      ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(PotionAbyssPlague.potion, 200, 0, false, false));
  }
}

