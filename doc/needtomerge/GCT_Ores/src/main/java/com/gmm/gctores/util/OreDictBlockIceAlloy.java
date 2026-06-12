
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.block.BlockIceAlloyBlock;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictBlockIceAlloy extends ElementsGctOresMod.ModElement
{
    public OreDictBlockIceAlloy(final ElementsGctOresMod instance) {
        super(instance, 346);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("blockIceAlloy", new ItemStack(BlockIceAlloyBlock.block, 1));
    }
}
