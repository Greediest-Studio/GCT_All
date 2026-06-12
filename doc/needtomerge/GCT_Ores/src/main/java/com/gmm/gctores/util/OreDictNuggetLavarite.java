
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemLavariteNugget;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictNuggetLavarite extends ElementsGctOresMod.ModElement
{
    public OreDictNuggetLavarite(final ElementsGctOresMod instance) {
        super(instance, 199);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("nuggetLavarite", new ItemStack(ItemLavariteNugget.block, 1));
    }
}
