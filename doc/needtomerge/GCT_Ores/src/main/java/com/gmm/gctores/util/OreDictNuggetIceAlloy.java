
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemIceAlloyNugget;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictNuggetIceAlloy extends ElementsGctOresMod.ModElement
{
    public OreDictNuggetIceAlloy(final ElementsGctOresMod instance) {
        super(instance, 356);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("nuggetIceAlloy", new ItemStack(ItemIceAlloyNugget.block, 1));
    }
}
