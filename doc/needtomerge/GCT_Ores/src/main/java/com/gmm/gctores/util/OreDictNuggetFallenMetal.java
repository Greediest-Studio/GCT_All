
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemFallenMetalNugget;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictNuggetFallenMetal extends ElementsGctOresMod.ModElement
{
    public OreDictNuggetFallenMetal(final ElementsGctOresMod instance) {
        super(instance, 380);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("nuggetFallenMetal", new ItemStack(ItemFallenMetalNugget.block, 1));
    }
}
