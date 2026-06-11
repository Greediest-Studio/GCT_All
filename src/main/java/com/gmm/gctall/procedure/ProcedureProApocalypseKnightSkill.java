package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.entity.EntityApocalypseCube;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class ProcedureProApocalypseKnightSkill {
  private ProcedureProApocalypseKnightSkill() {
  }

  public static void executeProcedure(Map<String, Object> dependencies) {
    if (!ProcedureContext.require(dependencies, "ProApocalypseKnightSkill", "x", "y", "z", "world"))
      return;
    int x = ProcedureContext.x(dependencies);
    int y = ProcedureContext.y(dependencies);
    int z = ProcedureContext.z(dependencies);
    World world = ProcedureContext.world(dependencies);
    if (world.rand.nextDouble() < 0.01D)
      for (EntityApocalypseCube.ApocalypseCubeEntity cube : ProcedureEffectHelper.livingWithin(EntityApocalypseCube.ApocalypseCubeEntity.class, world, new BlockPos(x, y, z), 16.0D))
        cube.setHealth(Math.min(cube.getMaxHealth(), cube.getHealth() + 32.0F));
  }
}

