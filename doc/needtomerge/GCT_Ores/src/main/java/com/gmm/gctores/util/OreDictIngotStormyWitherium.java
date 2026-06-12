
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemStormyWitheriumIngot;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictIngotStormyWitherium extends ElementsGctOresMod.ModElement
{
    public OreDictIngotStormyWitherium(final ElementsGctOresMod instance) {
        super(instance, 240);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("ingotWitheriumStormy", new ItemStack(ItemStormyWitheriumIngot.block, 1));
    }
}
