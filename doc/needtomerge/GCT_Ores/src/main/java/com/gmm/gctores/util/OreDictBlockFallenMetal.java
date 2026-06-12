
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.block.BlockFallenMetalBlock;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictBlockFallenMetal extends ElementsGctOresMod.ModElement
{
    public OreDictBlockFallenMetal(final ElementsGctOresMod instance) {
        super(instance, 387);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("blockFallenMetal", new ItemStack(BlockFallenMetalBlock.block, 1));
    }
}
