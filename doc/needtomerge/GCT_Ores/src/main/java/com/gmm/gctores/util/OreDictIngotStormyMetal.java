
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemStormyMetalIngot;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictIngotStormyMetal extends ElementsGctOresMod.ModElement
{
    public OreDictIngotStormyMetal(final ElementsGctOresMod instance) {
        super(instance, 226);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("ingotStormyMetal", new ItemStack(ItemStormyMetalIngot.block, 1));
    }
}
