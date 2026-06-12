
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemFallenMetalIngot;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictIngotFallenMetal extends ElementsGctOresMod.ModElement
{
    public OreDictIngotFallenMetal(final ElementsGctOresMod instance) {
        super(instance, 224);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("ingotFallenMetal", new ItemStack(ItemFallenMetalIngot.block, 1));
    }
}
