
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemReditritePlate;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictPlateReditrite extends ElementsGctOresMod.ModElement
{
    public OreDictPlateReditrite(final ElementsGctOresMod instance) {
        super(instance, 465);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("plateReditrite", new ItemStack(ItemReditritePlate.block, 1));
    }
}
