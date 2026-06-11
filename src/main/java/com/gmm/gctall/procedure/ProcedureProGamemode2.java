package com.gmm.gctall.procedure;

import java.util.Map;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.GameType;

public final class ProcedureProGamemode2 {
  private ProcedureProGamemode2() {
  }

  public static void executeProcedure(Map<String, Object> dependencies) {
    if (!ProcedureContext.require(dependencies, "ProGamemode2", "entity"))
      return;
    Entity entity = ProcedureContext.entity(dependencies);
    if (entity instanceof EntityPlayer)
      ((EntityPlayer)entity).setGameType(GameType.ADVENTURE);
  }
}

