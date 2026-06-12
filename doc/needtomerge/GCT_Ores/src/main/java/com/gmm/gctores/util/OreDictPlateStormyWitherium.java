
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemStormyWitheriumPlate;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictPlateStormyWitherium extends ElementsGctOresMod.ModElement
{
    public OreDictPlateStormyWitherium(final ElementsGctOresMod instance) {
        super(instance, 269);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("plateWitheriumStormy", new ItemStack(ItemStormyWitheriumPlate.block, 1));
    }
}
