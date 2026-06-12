
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.block.BlockStormyMetalBlock;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictBlockStormyMetal extends ElementsGctOresMod.ModElement
{
    public OreDictBlockStormyMetal(final ElementsGctOresMod instance) {
        super(instance, 389);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("blockStormyMetal", new ItemStack(BlockStormyMetalBlock.block, 1));
    }
}
