
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemDensitePlate;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictPlateDensite extends ElementsGctOresMod.ModElement
{
    public OreDictPlateDensite(final ElementsGctOresMod instance) {
        super(instance, 461);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("plateDensite", new ItemStack(ItemDensitePlate.block, 1));
    }
}
