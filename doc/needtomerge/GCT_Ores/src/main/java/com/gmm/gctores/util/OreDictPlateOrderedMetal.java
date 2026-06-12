
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemOrderedMetalPlate;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictPlateOrderedMetal extends ElementsGctOresMod.ModElement
{
    public OreDictPlateOrderedMetal(final ElementsGctOresMod instance) {
        super(instance, 447);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("plateOrderedMetal", new ItemStack(ItemOrderedMetalPlate.block, 1));
    }
}
