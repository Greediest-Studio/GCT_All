
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemOrderedMetalNugget;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictNuggetOrderedMetal extends ElementsGctOresMod.ModElement
{
    public OreDictNuggetOrderedMetal(final ElementsGctOresMod instance) {
        super(instance, 383);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("nuggetOrderedMetal", new ItemStack(ItemOrderedMetalNugget.block, 1));
    }
}
