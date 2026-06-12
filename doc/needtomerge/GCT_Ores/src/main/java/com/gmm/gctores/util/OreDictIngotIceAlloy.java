
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemIceAlloyIngot;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictIngotIceAlloy extends ElementsGctOresMod.ModElement
{
    public OreDictIngotIceAlloy(final ElementsGctOresMod instance) {
        super(instance, 351);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("ingotIceAlloy", new ItemStack(ItemIceAlloyIngot.block, 1));
    }
}
