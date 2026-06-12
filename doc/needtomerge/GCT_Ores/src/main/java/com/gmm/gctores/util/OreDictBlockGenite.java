
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.block.BlockGeniteBlock;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictBlockGenite extends ElementsGctOresMod.ModElement
{
    public OreDictBlockGenite(final ElementsGctOresMod instance) {
        super(instance, 494);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("blockGenite", new ItemStack(BlockGeniteBlock.block, 1));
    }
}
