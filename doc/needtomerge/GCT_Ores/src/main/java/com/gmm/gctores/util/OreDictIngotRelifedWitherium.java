
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemRelifedWitheriumIngot;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictIngotRelifedWitherium extends ElementsGctOresMod.ModElement
{
    public OreDictIngotRelifedWitherium(final ElementsGctOresMod instance) {
        super(instance, 239);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("ingotWitheriumRelifed", new ItemStack(ItemRelifedWitheriumIngot.block, 1));
    }
}
