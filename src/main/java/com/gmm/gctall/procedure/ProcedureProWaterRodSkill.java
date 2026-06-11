package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.util.ServerCommandHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public final class ProcedureProWaterRodSkill {
  private ProcedureProWaterRodSkill() {
  }

  public static void executeProcedure(Map<String, Object> dependencies) {
    if (!ProcedureContext.require(dependencies, "ProWaterRodSkill", "entity", "x", "y", "z", "world"))
      return;
    Entity entity = ProcedureContext.entity(dependencies);
    int x = ProcedureContext.x(dependencies);
    int y = ProcedureContext.y(dependencies);
    int z = ProcedureContext.z(dependencies);
    World world = ProcedureContext.world(dependencies);
    ServerCommandHelper.run(world, x, y, z, "fill ~1 ~ ~1 ~-1 ~16 ~-1 air");
    if (world.rand.nextDouble() < 0.001D &&
      entity instanceof EntityLivingBase)
      ((EntityLivingBase)entity).setHealth(0.0F);
  }
}

