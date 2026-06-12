
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemOrderedMetalIngot;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictIngotOrderedMetal extends ElementsGctOresMod.ModElement
{
    public OreDictIngotOrderedMetal(final ElementsGctOresMod instance) {
        super(instance, 378);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("ingotOrderedMetal", new ItemStack(ItemOrderedMetalIngot.block, 1));
    }
}
