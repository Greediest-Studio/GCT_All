
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemStormyWitheriumGear;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictGearStormyWitherium extends ElementsGctOresMod.ModElement
{
    public OreDictGearStormyWitherium(final ElementsGctOresMod instance) {
        super(instance, 266);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("gearWitheriumStormy", new ItemStack(ItemStormyWitheriumGear.block, 1));
    }
}
