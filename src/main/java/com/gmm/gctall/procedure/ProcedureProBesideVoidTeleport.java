package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.world.dimension.WorldBesideVoid;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;

public final class ProcedureProBesideVoidTeleport {
  private ProcedureProBesideVoidTeleport() {
  }

  public static void executeProcedure(Map<String, Object> dependencies) {
    if (!ProcedureContext.require(dependencies, "ProBesideVoidTeleport", "entity"))
      return;
    Entity entity = ProcedureContext.entity(dependencies);
    Entity _ent = entity;
    if (!_ent.world.isRemote && !_ent.isRiding() && !_ent.isBeingRidden() && _ent instanceof EntityPlayerMP) {
      int dimensionID = (_ent.dimension == WorldBesideVoid.DIMID) ? 0 : WorldBesideVoid.DIMID;
      EntityPlayerMP _player = (EntityPlayerMP)_ent;
      TeleporterDirect.transferToSpawn(_player, dimensionID);
    }
  }
}

