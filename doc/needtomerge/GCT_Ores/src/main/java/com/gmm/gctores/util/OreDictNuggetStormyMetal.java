
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemStormyMetalNugget;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictNuggetStormyMetal extends ElementsGctOresMod.ModElement
{
    public OreDictNuggetStormyMetal(final ElementsGctOresMod instance) {
        super(instance, 382);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("nuggetStormyMetal", new ItemStack(ItemStormyMetalNugget.block, 1));
    }
}
