
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.block.BlockChaoticDraconiumBlock;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictBlockChaoticDraconium extends ElementsGctOresMod.ModElement
{
    public OreDictBlockChaoticDraconium(final ElementsGctOresMod instance) {
        super(instance, 44);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("blockDraconiumChaotic", new ItemStack(BlockChaoticDraconiumBlock.block, 1));
    }
}
