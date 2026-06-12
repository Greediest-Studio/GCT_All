
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemReditriteNugget;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictNuggetReditrite extends ElementsGctOresMod.ModElement
{
    public OreDictNuggetReditrite(final ElementsGctOresMod instance) {
        super(instance, 67);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("nuggetReditrite", new ItemStack(ItemReditriteNugget.block, 1));
    }
}
