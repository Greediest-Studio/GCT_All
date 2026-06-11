package com.gmm.gctall.procedure;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import com.gmm.gctall.potion.PotionOverrestrain;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public final class ProcedureProOverrestrainTick {
  private ProcedureProOverrestrainTick() {
  }

  public static void executeProcedure(Map<String, Object> dependencies) {
    if (!ProcedureContext.require(dependencies, "ProOverrestrainTick", "entity"))
      return;
    final Entity entity = ProcedureContext.entity(dependencies);
    if ((new Object() {
        boolean check() {
          if (entity instanceof EntityLivingBase) {
            Collection<PotionEffect> effects = ((EntityLivingBase)entity).getActivePotionEffects();
            for (PotionEffect effect : effects) {
              if (effect.getPotion() == PotionOverrestrain.potion)
                return true;
            }
          }
          return false;
        }
      }).check())
      if (((entity instanceof EntityLivingBase) ? ((EntityLivingBase)entity)
        .getHealth() : -1.0F) <= ((entity instanceof EntityLivingBase) ? ((EntityLivingBase)entity)
        .getMaxHealth() : -1.0F) * 0.7D &&
        entity instanceof EntityLivingBase)
        ((EntityLivingBase)entity)
          .setHealth(
            (float)(((entity instanceof EntityLivingBase) ? ((EntityLivingBase)entity).getHealth() : -1.0F) + ((entity instanceof EntityLivingBase) ? ((EntityLivingBase)entity).getMaxHealth() : -1.0F) * 0.03D));
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

