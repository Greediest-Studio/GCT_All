package com.gmm.gctall.gui.overlay;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.procedure.ProcedureSanityRenderDisplayOverlayIngame;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Tag
public class OverlaySanityRender extends GctAllElement {
  public OverlaySanityRender(GctAllContent instance) {
    super(instance, 98);
  }
  
  @SideOnly(Side.CLIENT)
  public void init(FMLInitializationEvent event) {
    MinecraftForge.EVENT_BUS.register(new GUIRenderEventClass());
  }
  
  public static class GUIRenderEventClass {
    @SubscribeEvent(priority = EventPriority.NORMAL)
    @SideOnly(Side.CLIENT)
    public void eventHandler(RenderGameOverlayEvent event) {
      if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
        int posX = event.getResolution().getScaledWidth() / 2;
        int posY = event.getResolution().getScaledHeight() / 2;
        EntityPlayerSP entityPlayerSP = (Minecraft.getMinecraft()).player;
        World world = ((EntityPlayer)entityPlayerSP).world;
        int x = (int)((EntityPlayer)entityPlayerSP).posX;
        int y = (int)((EntityPlayer)entityPlayerSP).posY;
        int z = (int)((EntityPlayer)entityPlayerSP).posZ;
        if (ProcedureSanityRenderDisplayOverlayIngame.executeProcedure((Map)ImmutableMap.of("entity", entityPlayerSP))) {
          (Minecraft.getMinecraft()).fontRenderer.drawString("San", posX + -9, posY + -94, -1);
          (Minecraft.getMinecraft()).fontRenderer.drawString("" + entityPlayerSP.getEntityData().getFloat("sanityAbyss") + "", posX + -7, posY + -85, -1);
        } 
      } 
    }
  }
}

