
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemFallenMetalDust;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictDustFallenMetal extends ElementsGctOresMod.ModElement
{
    public OreDictDustFallenMetal(final ElementsGctOresMod instance) {
        super(instance, 436);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("dustFallenMetal", new ItemStack(ItemFallenMetalDust.block, 1));
    }
}
