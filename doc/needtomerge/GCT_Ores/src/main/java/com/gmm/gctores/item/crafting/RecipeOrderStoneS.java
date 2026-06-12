
package com.gmm.gctores.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import com.gmm.gctores.block.BlockOrderStone;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.block.BlockOrderCobblestone;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class RecipeOrderStoneS extends ElementsGctOresMod.ModElement
{
    public RecipeOrderStoneS(final ElementsGctOresMod instance) {
        super(instance, 393);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        GameRegistry.addSmelting(new ItemStack(BlockOrderCobblestone.block, 1), new ItemStack(BlockOrderStone.block, 1), 1.0f);
    }
}
