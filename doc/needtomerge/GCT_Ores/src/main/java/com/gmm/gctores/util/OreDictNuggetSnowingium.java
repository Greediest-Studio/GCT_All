
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemSnowingiumNugget;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictNuggetSnowingium extends ElementsGctOresMod.ModElement
{
    public OreDictNuggetSnowingium(final ElementsGctOresMod instance) {
        super(instance, 352);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("nuggetSnowingium", new ItemStack(ItemSnowingiumNugget.block, 1));
    }
}
