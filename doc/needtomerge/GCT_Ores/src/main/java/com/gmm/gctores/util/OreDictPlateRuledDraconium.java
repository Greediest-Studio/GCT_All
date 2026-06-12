
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemRuledDraconiumPlate;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictPlateRuledDraconium extends ElementsGctOresMod.ModElement
{
    public OreDictPlateRuledDraconium(final ElementsGctOresMod instance) {
        super(instance, 251);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("plateDraconiumRuled", new ItemStack(ItemRuledDraconiumPlate.block, 1));
    }
}
