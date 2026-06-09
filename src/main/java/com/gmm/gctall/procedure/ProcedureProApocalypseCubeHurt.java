package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;

@Tag
public class ProcedureProApocalypseCubeHurt extends GctAllElement {
  public ProcedureProApocalypseCubeHurt(GctAllContent instance) {
    super(instance, 99);
  }
  
  public static void executeProcedure(Map<String, Object> dependencies) {
    if (!ProcedureContext.require(dependencies, "ProApocalypseCubeHurt", "entity", "x", "y", "z"))
      return;
    Entity entity = ProcedureContext.entity(dependencies);
    int x = ProcedureContext.x(dependencies);
    int y = ProcedureContext.y(dependencies);
    int z = ProcedureContext.z(dependencies);
    if (entity.world.rand.nextDouble() < 0.3D) {
      entity.attackEntityFrom(DamageSource.GENERIC, ((entity instanceof EntityLivingBase) ? ((EntityLivingBase)entity)
          .getMaxHealth() : -1.0F) / 15.0F);
      entity.setPositionAndUpdate(x + entity.world.rand.nextInt(11), y + entity.world.rand.nextInt(11), z + entity.world.rand.nextInt(11));
    } 
  }
}

