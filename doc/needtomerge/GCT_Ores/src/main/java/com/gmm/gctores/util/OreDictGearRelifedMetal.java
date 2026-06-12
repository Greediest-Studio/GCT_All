
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemRelifedMetalGear;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictGearRelifedMetal extends ElementsGctOresMod.ModElement
{
    public OreDictGearRelifedMetal(final ElementsGctOresMod instance) {
        super(instance, 441);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("gearRelifedMetal", new ItemStack(ItemRelifedMetalGear.block, 1));
    }
}
