package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.GameType;

@Tag
public class ProcedureProGamemode3 extends GctAllElement {
  public ProcedureProGamemode3(GctAllContent instance) {
    super(instance, 382);
  }
  
  public static void executeProcedure(Map<String, Object> dependencies) {
    if (!ProcedureContext.require(dependencies, "ProGamemode3", "entity"))
      return;
    Entity entity = ProcedureContext.entity(dependencies);
    if (entity instanceof EntityPlayer)
      ((EntityPlayer)entity).setGameType(GameType.SPECTATOR); 
  }
}

