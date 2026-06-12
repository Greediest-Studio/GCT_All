
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemGeniteNugget;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictNuggetGenite extends ElementsGctOresMod.ModElement
{
    public OreDictNuggetGenite(final ElementsGctOresMod instance) {
        super(instance, 491);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("nuggetGenite", new ItemStack(ItemGeniteNugget.block, 1));
    }
}
