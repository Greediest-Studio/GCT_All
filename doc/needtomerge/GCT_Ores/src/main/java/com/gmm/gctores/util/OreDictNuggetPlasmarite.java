
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemPlasmariteNugget;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictNuggetPlasmarite extends ElementsGctOresMod.ModElement
{
    public OreDictNuggetPlasmarite(final ElementsGctOresMod instance) {
        super(instance, 197);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("nuggetPlasmarite", new ItemStack(ItemPlasmariteNugget.block, 1));
    }
}
