package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import net.minecraft.world.World;

@Tag
public class ProcedureProApocalypseBomb extends GctAllElement {
  public ProcedureProApocalypseBomb(GctAllContent instance) {
    super(instance, 100);
  }
  
  public static void executeProcedure(Map<String, Object> dependencies) {
    if (!ProcedureContext.require(dependencies, "ProApocalypseBomb", "x", "y", "z", "world"))
      return;
    int x = ProcedureContext.x(dependencies);
    int y = ProcedureContext.y(dependencies);
    int z = ProcedureContext.z(dependencies);
    World world = ProcedureContext.world(dependencies);
    if (!world.isRemote)
      world.createExplosion(null, x, y, z, 3.0F, true); 
  }
}

