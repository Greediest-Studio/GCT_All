
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemEveritePlate;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictPlateEverite extends ElementsGctOresMod.ModElement
{
    public OreDictPlateEverite(final ElementsGctOresMod instance) {
        super(instance, 406);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("plateEverite", new ItemStack(ItemEveritePlate.block, 1));
    }
}
