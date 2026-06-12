
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.block.BlockReditriteCobblestone;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictBlockReditritecobble extends ElementsGctOresMod.ModElement
{
    public OreDictBlockReditritecobble(final ElementsGctOresMod instance) {
        super(instance, 69);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("blockReditritecobble", new ItemStack(BlockReditriteCobblestone.block, 1));
    }
}
