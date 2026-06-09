package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.item.ItemSanityObserver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

@Tag
public class ProcedureSanityRenderDisplayOverlayIngame extends GctAllElement {
  public ProcedureSanityRenderDisplayOverlayIngame(GctAllContent instance) {
    super(instance, 98);
  }
  
  public static boolean executeProcedure(Map<String, Object> dependencies) {
    if (dependencies.get("entity") == null) {
      System.err.println("Failed to load dependency entity for procedure SanityRenderDisplayOverlayIngame!");
      return false;
    } 
    Entity entity = (Entity)dependencies.get("entity");
    if (entity instanceof EntityPlayer && ((EntityPlayer)entity).inventory
      .hasItemStack(new ItemStack(ItemSanityObserver.block, 1)))
      return true; 
    return false;
  }
}

