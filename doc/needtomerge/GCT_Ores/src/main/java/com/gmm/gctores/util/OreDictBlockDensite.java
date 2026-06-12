
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.block.BlockDensiteBlock;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictBlockDensite extends ElementsGctOresMod.ModElement
{
    public OreDictBlockDensite(final ElementsGctOresMod instance) {
        super(instance, 54);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("blockDensite", new ItemStack(BlockDensiteBlock.block, 1));
    }
}
