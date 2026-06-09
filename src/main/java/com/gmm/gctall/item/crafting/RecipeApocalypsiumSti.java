package com.gmm.gctall.item.crafting;

import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.item.ItemApocalypsiumIngot;
import com.gmm.gctall.item.ItemApocalypsiumScrap;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Tag
public class RecipeApocalypsiumSti extends GctAllElement {
  public RecipeApocalypsiumSti(GctAllContent instance) {
    super(instance, 81);
  }
  
  public void init(FMLInitializationEvent event) {
    GameRegistry.addSmelting(new ItemStack(ItemApocalypsiumScrap.block, 1), new ItemStack(ItemApocalypsiumIngot.block, 1), 1.0F);
  }
}

