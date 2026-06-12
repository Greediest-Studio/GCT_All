
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemDensiteGear;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictGearDensite extends ElementsGctOresMod.ModElement
{
    public OreDictGearDensite(final ElementsGctOresMod instance) {
        super(instance, 471);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("Geardensite", new ItemStack(ItemDensiteGear.block, 1));
    }
}
