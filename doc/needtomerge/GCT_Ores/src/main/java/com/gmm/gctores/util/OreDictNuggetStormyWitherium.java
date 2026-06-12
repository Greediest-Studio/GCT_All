
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemStormyWitheriumNugget;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictNuggetStormyWitherium extends ElementsGctOresMod.ModElement
{
    public OreDictNuggetStormyWitherium(final ElementsGctOresMod instance) {
        super(instance, 263);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("nuggetWitheriumStormy", new ItemStack(ItemStormyWitheriumNugget.block, 1));
    }
}
