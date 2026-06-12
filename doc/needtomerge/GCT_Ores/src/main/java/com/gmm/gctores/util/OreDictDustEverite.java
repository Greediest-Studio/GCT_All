
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemEveriteDust;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictDustEverite extends ElementsGctOresMod.ModElement
{
    public OreDictDustEverite(final ElementsGctOresMod instance) {
        super(instance, 405);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("dustEverite", new ItemStack(ItemEveriteDust.block, 1));
    }
}
