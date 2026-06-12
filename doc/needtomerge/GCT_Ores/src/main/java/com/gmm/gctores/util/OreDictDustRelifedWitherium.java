
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemRelifedWitheriumDust;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictDustRelifedWitherium extends ElementsGctOresMod.ModElement
{
    public OreDictDustRelifedWitherium(final ElementsGctOresMod instance) {
        super(instance, 283);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("dustWitheriumRelifed", new ItemStack(ItemRelifedWitheriumDust.block, 1));
    }
}
