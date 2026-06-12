
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemOrderedMetalGear;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictGearOrderedMetal extends ElementsGctOresMod.ModElement
{
    public OreDictGearOrderedMetal(final ElementsGctOresMod instance) {
        super(instance, 443);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("gearOrderedMetal", new ItemStack(ItemOrderedMetalGear.block, 1));
    }
}
