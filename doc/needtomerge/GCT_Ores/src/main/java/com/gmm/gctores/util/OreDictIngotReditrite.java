
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemReditriteIngot;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictIngotReditrite extends ElementsGctOresMod.ModElement
{
    public OreDictIngotReditrite(final ElementsGctOresMod instance) {
        super(instance, 66);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("ingotReditrite", new ItemStack(ItemReditriteIngot.block, 1));
    }
}
