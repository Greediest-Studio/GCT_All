
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemRuledDraconiumIngot;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictIngotRuledDraconium extends ElementsGctOresMod.ModElement
{
    public OreDictIngotRuledDraconium(final ElementsGctOresMod instance) {
        super(instance, 238);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("ingotDraconiumRuled", new ItemStack(ItemRuledDraconiumIngot.block, 1));
    }
}
