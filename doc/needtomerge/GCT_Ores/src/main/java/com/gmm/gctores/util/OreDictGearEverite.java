
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemEveriteGear;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictGearEverite extends ElementsGctOresMod.ModElement
{
    public OreDictGearEverite(final ElementsGctOresMod instance) {
        super(instance, 407);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("gearEverite", new ItemStack(ItemEveriteGear.block, 1));
    }
}
