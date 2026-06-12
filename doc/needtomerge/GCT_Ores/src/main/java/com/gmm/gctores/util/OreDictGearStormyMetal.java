
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemStormyMetalGear;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictGearStormyMetal extends ElementsGctOresMod.ModElement
{
    public OreDictGearStormyMetal(final ElementsGctOresMod instance) {
        super(instance, 442);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("gearStormyMetal", new ItemStack(ItemStormyMetalGear.block, 1));
    }
}
