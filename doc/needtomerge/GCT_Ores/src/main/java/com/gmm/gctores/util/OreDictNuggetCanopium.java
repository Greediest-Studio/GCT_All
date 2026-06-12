
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemCanopiumNugget;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictNuggetCanopium extends ElementsGctOresMod.ModElement
{
    public OreDictNuggetCanopium(final ElementsGctOresMod instance) {
        super(instance, 35);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("nuggetCanopium", new ItemStack(ItemCanopiumNugget.block, 1));
    }
}
