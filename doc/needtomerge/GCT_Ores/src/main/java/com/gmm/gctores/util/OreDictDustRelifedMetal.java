
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemRelifedMetalDust;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictDustRelifedMetal extends ElementsGctOresMod.ModElement
{
    public OreDictDustRelifedMetal(final ElementsGctOresMod instance) {
        super(instance, 437);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("dustRelifedMetal", new ItemStack(ItemRelifedMetalDust.block, 1));
    }
}
