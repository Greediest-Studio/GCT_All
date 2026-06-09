package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.world.dimension.WorldBesideVoid;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;

@Tag
public class ProcedureProBesideVoidTeleport extends GctAllElement {
  public ProcedureProBesideVoidTeleport(GctAllContent instance) {
    super(instance, 159);
  }
  
  public static void executeProcedure(Map<String, Object> dependencies) {
    if (!ProcedureContext.require(dependencies, "ProBesideVoidTeleport", "entity"))
      return;
    Entity entity = ProcedureContext.entity(dependencies);
    Entity _ent = entity;
    if (!_ent.world.isRemote && !_ent.isRiding() && !_ent.isBeingRidden() && _ent instanceof EntityPlayerMP) {
      int dimensionID = WorldBesideVoid.DIMID;
      EntityPlayerMP _player = (EntityPlayerMP)_ent;
      TeleporterDirect.transferToSpawn(_player, dimensionID);
    } 
  }
}

