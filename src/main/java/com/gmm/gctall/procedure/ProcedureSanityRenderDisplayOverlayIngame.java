package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.item.ItemSanityObserver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public final class ProcedureSanityRenderDisplayOverlayIngame {
  private ProcedureSanityRenderDisplayOverlayIngame() {
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

