
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemRelifedWitheriumPlate;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictPlateRelifedWitherium extends ElementsGctOresMod.ModElement
{
    public OreDictPlateRelifedWitherium(final ElementsGctOresMod instance) {
        super(instance, 268);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("plateWitheriumRelifed", new ItemStack(ItemRelifedWitheriumPlate.block, 1));
    }
}
