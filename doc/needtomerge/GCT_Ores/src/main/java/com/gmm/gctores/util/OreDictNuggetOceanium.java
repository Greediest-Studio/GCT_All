
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemOceaniumNugget;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictNuggetOceanium extends ElementsGctOresMod.ModElement
{
    public OreDictNuggetOceanium(final ElementsGctOresMod instance) {
        super(instance, 354);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("nuggetOceanium", new ItemStack(ItemOceaniumNugget.block, 1));
    }
}
