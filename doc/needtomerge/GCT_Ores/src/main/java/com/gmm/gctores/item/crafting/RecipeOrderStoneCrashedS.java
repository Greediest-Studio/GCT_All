
package com.gmm.gctores.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import com.gmm.gctores.block.BlockOrderStoneBrickCrashed;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.block.BlockOrderStoneBrick;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class RecipeOrderStoneCrashedS extends ElementsGctOresMod.ModElement
{
    public RecipeOrderStoneCrashedS(final ElementsGctOresMod instance) {
        super(instance, 398);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        GameRegistry.addSmelting(new ItemStack(BlockOrderStoneBrick.block, 1), new ItemStack(BlockOrderStoneBrickCrashed.block, 1), 1.0f);
    }
}
