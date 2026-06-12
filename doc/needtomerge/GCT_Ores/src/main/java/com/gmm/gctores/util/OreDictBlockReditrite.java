
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.block.BlockReditriteBlock;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictBlockReditrite extends ElementsGctOresMod.ModElement
{
    public OreDictBlockReditrite(final ElementsGctOresMod instance) {
        super(instance, 68);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("blockReditrite", new ItemStack(BlockReditriteBlock.block, 1));
    }
}
