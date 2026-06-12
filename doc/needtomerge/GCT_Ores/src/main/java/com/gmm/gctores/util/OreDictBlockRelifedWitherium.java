
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.block.BlockRelifedWitheriumBlock;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictBlockRelifedWitherium extends ElementsGctOresMod.ModElement
{
    public OreDictBlockRelifedWitherium(final ElementsGctOresMod instance) {
        super(instance, 259);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("blockWitheriumRelifed", new ItemStack(BlockRelifedWitheriumBlock.block, 1));
    }
}
