package com.gmm.gctall.procedure;

import java.util.HashMap;
import java.util.Map;
import com.gmm.gctall.item.ItemAtlantis;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public final class ProcedureProElderGuardianDeath {
  private ProcedureProElderGuardianDeath() {
  }

  public static void executeProcedure(Map<String, Object> dependencies) {
    if (!ProcedureContext.require(dependencies, "ProElderGuardianDeath", "entity", "x", "y", "z", "world"))
      return;
    Entity entity = ProcedureContext.entity(dependencies);
    int x = ProcedureContext.x(dependencies);
    int y = ProcedureContext.y(dependencies);
    int z = ProcedureContext.z(dependencies);
    World world = ProcedureContext.world(dependencies);
    if (entity instanceof net.minecraft.entity.monster.EntityElderGuardian &&
      !world.isRemote) {
      EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(ItemAtlantis.block, 1));
      entityToSpawn.setPickupDelay(10);
      world.spawnEntity((Entity)entityToSpawn);
    }
  }

  @SubscribeEvent
  public void onEntityDeath(LivingDeathEvent event) {
    if (event != null && event.getEntity() != null) {
      Entity entity = event.getEntity();
      int i = (int)entity.posX;
      int j = (int)entity.posY;
      int k = (int)entity.posZ;
      World world = entity.world;
      HashMap<String, Object> dependencies = new HashMap<>();
      dependencies.put("x", Integer.valueOf(i));
      dependencies.put("y", Integer.valueOf(j));
      dependencies.put("z", Integer.valueOf(k));
      dependencies.put("world", world);
      dependencies.put("entity", entity);
      dependencies.put("event", event);
      executeProcedure(dependencies);
    }
  }

  public void preInit(FMLPreInitializationEvent event) {
    MinecraftForge.EVENT_BUS.register(this);
  }
}

