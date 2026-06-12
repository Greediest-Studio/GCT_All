
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.block.BlockSkyAlloyBlock;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictBlockSkyAlloy extends ElementsGctOresMod.ModElement
{
    public OreDictBlockSkyAlloy(final ElementsGctOresMod instance) {
        super(instance, 43);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("blockSkyAlloy", new ItemStack(BlockSkyAlloyBlock.block, 1));
    }
}
