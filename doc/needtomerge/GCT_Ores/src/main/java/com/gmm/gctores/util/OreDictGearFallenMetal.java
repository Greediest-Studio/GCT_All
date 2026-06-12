
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemFallenMetalGear;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictGearFallenMetal extends ElementsGctOresMod.ModElement
{
    public OreDictGearFallenMetal(final ElementsGctOresMod instance) {
        super(instance, 440);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("gearFallenMetal", new ItemStack(ItemFallenMetalGear.block, 1));
    }
}
