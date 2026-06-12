
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.block.BlockOrderCrystalOre;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictOreOrderCrystal extends ElementsGctOresMod.ModElement
{
    public OreDictOreOrderCrystal(final ElementsGctOresMod instance) {
        super(instance, 374);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("oreOrderCrystal", new ItemStack(BlockOrderCrystalOre.block, 1));
    }
}
