
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemDensiteDust;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictDustDensite extends ElementsGctOresMod.ModElement
{
    public OreDictDustDensite(final ElementsGctOresMod instance) {
        super(instance, 115);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("dustDensite", new ItemStack(ItemDensiteDust.block, 1));
    }
}
