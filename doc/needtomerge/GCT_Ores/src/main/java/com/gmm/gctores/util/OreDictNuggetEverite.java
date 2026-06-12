
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemEveriteNugget;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictNuggetEverite extends ElementsGctOresMod.ModElement
{
    public OreDictNuggetEverite(final ElementsGctOresMod instance) {
        super(instance, 404);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("nuggetEverite", new ItemStack(ItemEveriteNugget.block, 1));
    }
}
