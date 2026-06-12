
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemThyminiteNugget;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictNuggetThyminite extends ElementsGctOresMod.ModElement
{
    public OreDictNuggetThyminite(final ElementsGctOresMod instance) {
        super(instance, 34);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("nuggetThyminite", new ItemStack(ItemThyminiteNugget.block, 1));
    }
}
