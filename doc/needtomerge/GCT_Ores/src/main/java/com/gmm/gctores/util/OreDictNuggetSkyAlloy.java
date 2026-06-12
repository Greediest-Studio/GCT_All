
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemSkyAlloyNugget;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictNuggetSkyAlloy extends ElementsGctOresMod.ModElement
{
    public OreDictNuggetSkyAlloy(final ElementsGctOresMod instance) {
        super(instance, 36);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("nuggetSkyAlloy", new ItemStack(ItemSkyAlloyNugget.block, 1));
    }
}
