
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemRelifedMetalNugget;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictNuggetRelifedMetal extends ElementsGctOresMod.ModElement
{
    public OreDictNuggetRelifedMetal(final ElementsGctOresMod instance) {
        super(instance, 381);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("nuggetRelifedMetal", new ItemStack(ItemRelifedMetalNugget.block, 1));
    }
}
