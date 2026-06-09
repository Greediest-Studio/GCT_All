package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.util.ServerCommandHelper;
import net.minecraft.world.World;

@Tag
public class ProcedureProApocalypseKnightSkill extends GctAllElement {
  public ProcedureProApocalypseKnightSkill(GctAllContent instance) {
    super(instance, 160);
  }
  
  public static void executeProcedure(Map<String, Object> dependencies) {
    if (!ProcedureContext.require(dependencies, "ProApocalypseKnightSkill", "x", "y", "z", "world"))
      return;
    int x = ProcedureContext.x(dependencies);
    int y = ProcedureContext.y(dependencies);
    int z = ProcedureContext.z(dependencies);
    World world = ProcedureContext.world(dependencies);
    if (world.rand.nextDouble() < 0.01D)
      ServerCommandHelper.run(world, x, y, z, "effect @e[type=gct_all:apocalypse_cube, r=16] instant_health 1 6"); 
  }
}

