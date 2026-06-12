
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemMistiumNugget;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictNuggetMistium extends ElementsGctOresMod.ModElement
{
    public OreDictNuggetMistium(final ElementsGctOresMod instance) {
        super(instance, 45);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("nuggetMistium", new ItemStack(ItemMistiumNugget.block, 1));
    }
}
