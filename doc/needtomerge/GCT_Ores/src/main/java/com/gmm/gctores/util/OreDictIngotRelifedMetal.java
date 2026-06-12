
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemRelifedMetalIngot;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictIngotRelifedMetal extends ElementsGctOresMod.ModElement
{
    public OreDictIngotRelifedMetal(final ElementsGctOresMod instance) {
        super(instance, 225);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("ingotRelifedMetal", new ItemStack(ItemRelifedMetalIngot.block, 1));
    }
}
