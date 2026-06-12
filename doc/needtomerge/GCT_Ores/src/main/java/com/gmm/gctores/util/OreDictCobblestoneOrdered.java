
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.block.BlockOrderCobblestone;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictCobblestoneOrdered extends ElementsGctOresMod.ModElement
{
    public OreDictCobblestoneOrdered(final ElementsGctOresMod instance) {
        super(instance, 395);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("cobblestoneOrdered", new ItemStack(BlockOrderCobblestone.block, 1));
    }
}
