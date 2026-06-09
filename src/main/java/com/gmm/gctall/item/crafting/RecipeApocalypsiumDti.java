package com.gmm.gctall.item.crafting;

import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.item.ItemApocalypsiumDust;
import com.gmm.gctall.item.ItemApocalypsiumIngot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Tag
public class RecipeApocalypsiumDti extends GctAllElement {
  public RecipeApocalypsiumDti(GctAllContent instance) {
    super(instance, 122);
  }
  
  public void init(FMLInitializationEvent event) {
    GameRegistry.addSmelting(new ItemStack(ItemApocalypsiumDust.block, 1), new ItemStack(ItemApocalypsiumIngot.block, 1), 0.0F);
  }
}

