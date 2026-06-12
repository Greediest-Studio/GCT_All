
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemReditriteDust;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictDustReditrite extends ElementsGctOresMod.ModElement
{
    public OreDictDustReditrite(final ElementsGctOresMod instance) {
        super(instance, 117);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("dustReditrite", new ItemStack(ItemReditriteDust.block, 1));
    }
}
