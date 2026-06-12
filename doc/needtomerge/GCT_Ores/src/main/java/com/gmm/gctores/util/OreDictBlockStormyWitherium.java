
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.block.BlockStormyWitheriumBlock;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictBlockStormyWitherium extends ElementsGctOresMod.ModElement
{
    public OreDictBlockStormyWitherium(final ElementsGctOresMod instance) {
        super(instance, 260);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("blockWitheriumStormy", new ItemStack(BlockStormyWitheriumBlock.block, 1));
    }
}
