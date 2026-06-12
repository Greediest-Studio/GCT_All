
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.block.BlockRelifedMetalBlock;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictBlockRelifedMetal extends ElementsGctOresMod.ModElement
{
    public OreDictBlockRelifedMetal(final ElementsGctOresMod instance) {
        super(instance, 388);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("blockRelifedMetal", new ItemStack(BlockRelifedMetalBlock.block, 1));
    }
}
