
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemRelifedWitheriumGear;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictGearRelifedWitherium extends ElementsGctOresMod.ModElement
{
    public OreDictGearRelifedWitherium(final ElementsGctOresMod instance) {
        super(instance, 265);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("gearWitheriumRelifed", new ItemStack(ItemRelifedWitheriumGear.block, 1));
    }
}
