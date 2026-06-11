package com.gmm.gctall.procedure;

import java.util.Map;
import net.minecraft.item.ItemStack;

public final class ProcedureProEarthOrbGlow {
  private ProcedureProEarthOrbGlow() {
  }

  public static boolean executeProcedure(Map<String, Object> dependencies) {
    if (!ProcedureContext.require(dependencies, "ProEarthOrbGlow", "itemstack"))
      return false;
    ItemStack itemstack = ProcedureContext.itemStack(dependencies, "itemstack");
    if (itemstack.getItemDamage() == 0)
      return true;
    return false;
  }
}

