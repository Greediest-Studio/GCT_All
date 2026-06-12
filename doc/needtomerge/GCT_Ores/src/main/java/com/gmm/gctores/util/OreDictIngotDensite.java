
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemDensiteIngot;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictIngotDensite extends ElementsGctOresMod.ModElement
{
    public OreDictIngotDensite(final ElementsGctOresMod instance) {
        super(instance, 51);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("ingotDensite", new ItemStack(ItemDensiteIngot.block, 1));
    }
}
