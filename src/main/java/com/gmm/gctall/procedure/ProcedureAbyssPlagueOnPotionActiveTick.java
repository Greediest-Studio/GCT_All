package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;

@Tag
public class ProcedureAbyssPlagueOnPotionActiveTick extends GctAllElement {
  public ProcedureAbyssPlagueOnPotionActiveTick(GctAllContent instance) {
    super(instance, 8);
  }
  
  public static void executeProcedure(Map<String, Object> dependencies) {
    if (dependencies.get("entity") == null) {
      System.err.println("Failed to load dependency entity for procedure AbyssPlagueOnPotionActiveTick!");
      return;
    } 
    Entity entity = (Entity)dependencies.get("entity");
    entity.getEntityData().setDouble("abypla", entity.getEntityData().getDouble("abypla") + 1.0D);
    if (entity.getEntityData().getDouble("abypla") % 10.0D == 0.0D)
      entity.attackEntityFrom(DamageSource.MAGIC, 2.0F); 
  }
}

