package com.gmm.gctall.procedure;

import java.util.HashMap;
import java.util.Map;
import com.gmm.gctall.world.dimension.WorldStarland;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public final class ProcedureProStarlandKick {
  private ProcedureProStarlandKick() {
  }

  public static void executeProcedure(Map<String, Object> dependencies) {
    if (!ProcedureContext.require(dependencies, "ProStarlandKick", "entity", "world"))
      return;
    Entity entity = ProcedureContext.entity(dependencies);
    World world = ProcedureContext.world(dependencies);
    if (entity.dimension == WorldStarland.DIMID &&
      world.getWorldTime() % 24000L <= 12000L) {
      Entity _ent = entity;
      if (!_ent.world.isRemote && !_ent.isRiding() && !_ent.isBeingRidden() && _ent instanceof EntityPlayerMP) {
        int dimensionID = 0;
        EntityPlayerMP _player = (EntityPlayerMP)_ent;
        TeleporterDirect.transferToSpawn(_player, dimensionID);
      }
    }
  }

  @SubscribeEvent
  public void onPlayerTick(TickEvent.PlayerTickEvent event) {
    if (event.phase == TickEvent.Phase.END) {
      EntityPlayer entityPlayer = event.player;
      World world = ((Entity)entityPlayer).world;
      int i = (int)((Entity)entityPlayer).posX;
      int j = (int)((Entity)entityPlayer).posY;
      int k = (int)((Entity)entityPlayer).posZ;
      HashMap<String, Object> dependencies = new HashMap<>();
      dependencies.put("x", Integer.valueOf(i));
      dependencies.put("y", Integer.valueOf(j));
      dependencies.put("z", Integer.valueOf(k));
      dependencies.put("world", world);
      dependencies.put("entity", entityPlayer);
      dependencies.put("event", event);
      executeProcedure(dependencies);
    }
  }

  public void preInit(FMLPreInitializationEvent event) {
    MinecraftForge.EVENT_BUS.register(this);
  }
}

