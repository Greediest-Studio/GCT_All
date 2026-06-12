
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemReditriteGear;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictGearReditrite extends ElementsGctOresMod.ModElement
{
    public OreDictGearReditrite(final ElementsGctOresMod instance) {
        super(instance, 480);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("gearReditrite", new ItemStack(ItemReditriteGear.block, 1));
    }
}
