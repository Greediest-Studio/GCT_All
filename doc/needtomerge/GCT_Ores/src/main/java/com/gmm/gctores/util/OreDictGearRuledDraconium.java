
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemRuledDraconiumGear;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictGearRuledDraconium extends ElementsGctOresMod.ModElement
{
    public OreDictGearRuledDraconium(final ElementsGctOresMod instance) {
        super(instance, 250);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("gearDraconiumRuled", new ItemStack(ItemRuledDraconiumGear.block, 1));
    }
}
