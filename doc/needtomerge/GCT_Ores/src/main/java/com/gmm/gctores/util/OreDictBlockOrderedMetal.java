
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.block.BlockOrderedMetalBlock;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictBlockOrderedMetal extends ElementsGctOresMod.ModElement
{
    public OreDictBlockOrderedMetal(final ElementsGctOresMod instance) {
        super(instance, 391);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("blockOrderedMetal", new ItemStack(BlockOrderedMetalBlock.block, 1));
    }
}
