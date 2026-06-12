
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemSkyAlloyIngot;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictIngotSkyAlloy extends ElementsGctOresMod.ModElement
{
    public OreDictIngotSkyAlloy(final ElementsGctOresMod instance) {
        super(instance, 31);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("ingotSkyAlloy", new ItemStack(ItemSkyAlloyIngot.block, 1));
    }
}
