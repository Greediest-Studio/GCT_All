
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemEveriteIngot;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictIngotEverite extends ElementsGctOresMod.ModElement
{
    public OreDictIngotEverite(final ElementsGctOresMod instance) {
        super(instance, 403);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("ingotEverite", new ItemStack(ItemEveriteIngot.block, 1));
    }
}
