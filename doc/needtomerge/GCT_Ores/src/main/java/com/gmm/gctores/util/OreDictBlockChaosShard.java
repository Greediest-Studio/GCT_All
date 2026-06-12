
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.block.BlockChaosShardBlock;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictBlockChaosShard extends ElementsGctOresMod.ModElement
{
    public OreDictBlockChaosShard(final ElementsGctOresMod instance) {
        super(instance, 319);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("blockChaosShard", new ItemStack(BlockChaosShardBlock.block, 1));
    }
}
