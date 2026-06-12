
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.block.BlockStormyShardBlock;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictBlockStormyShard extends ElementsGctOresMod.ModElement
{
    public OreDictBlockStormyShard(final ElementsGctOresMod instance) {
        super(instance, 318);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("blockStormyShard", new ItemStack(BlockStormyShardBlock.block, 1));
    }
}
