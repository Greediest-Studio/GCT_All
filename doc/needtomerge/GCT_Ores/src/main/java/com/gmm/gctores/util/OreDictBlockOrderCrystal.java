
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.block.BlockOrderCrystalBlock;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictBlockOrderCrystal extends ElementsGctOresMod.ModElement
{
    public OreDictBlockOrderCrystal(final ElementsGctOresMod instance) {
        super(instance, 394);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("blockOrderCrystal", new ItemStack(BlockOrderCrystalBlock.block, 1));
    }
}
