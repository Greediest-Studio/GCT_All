
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemOrderedCore;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictCoreOrdered extends ElementsGctOresMod.ModElement
{
    public OreDictCoreOrdered(final ElementsGctOresMod instance) {
        super(instance, 314);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("coreOrdered", new ItemStack(ItemOrderedCore.block, 1));
    }
}
