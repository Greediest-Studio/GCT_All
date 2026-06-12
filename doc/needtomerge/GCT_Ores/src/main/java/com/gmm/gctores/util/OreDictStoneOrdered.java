
package com.gmm.gctores.util;

import com.gmm.gctores.block.BlockOrderStoneBrickChiseled;
import com.gmm.gctores.block.BlockOrderStoneBrick;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.block.BlockOrderStone;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictStoneOrdered extends ElementsGctOresMod.ModElement
{
    public OreDictStoneOrdered(final ElementsGctOresMod instance) {
        super(instance, 396);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("stoneOrdered", new ItemStack(BlockOrderStone.block, 1));
        OreDictionary.registerOre("stoneOrdered", new ItemStack(BlockOrderStoneBrick.block, 1));
        OreDictionary.registerOre("stoneOrdered", new ItemStack(BlockOrderStoneBrickChiseled.block, 1));
    }
}
