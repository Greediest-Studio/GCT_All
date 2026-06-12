
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.block.BlockRuledDraconiumBlock;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictBlockRuledDraconium extends ElementsGctOresMod.ModElement
{
    public OreDictBlockRuledDraconium(final ElementsGctOresMod instance) {
        super(instance, 247);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("blockDraconiumRuled", new ItemStack(BlockRuledDraconiumBlock.block, 1));
    }
}
