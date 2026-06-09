package com.gmm.gctall.item.crafting;

import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.block.BlockManaCobbleStone;
import com.gmm.gctall.block.BlockManaStone;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Tag
public class RecipeManaCobbleStoneSmelt extends GctAllElement {
  public RecipeManaCobbleStoneSmelt(GctAllContent instance) {
    super(instance, 190);
  }
  
  public void init(FMLInitializationEvent event) {
    GameRegistry.addSmelting(new ItemStack(BlockManaCobbleStone.block, 1), new ItemStack(BlockManaStone.block, 1), 0.0F);
  }
}

