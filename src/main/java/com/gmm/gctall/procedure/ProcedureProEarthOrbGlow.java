package com.gmm.gctall.procedure;

import java.util.Map;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import net.minecraft.item.ItemStack;

@Tag
public class ProcedureProEarthOrbGlow extends GctAllElement {
  public ProcedureProEarthOrbGlow(GctAllContent instance) {
    super(instance, 371);
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

