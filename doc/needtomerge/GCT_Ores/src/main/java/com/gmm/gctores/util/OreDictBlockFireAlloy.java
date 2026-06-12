
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.block.BlockFireAlloyBlock;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictBlockFireAlloy extends ElementsGctOresMod.ModElement
{
    public OreDictBlockFireAlloy(final ElementsGctOresMod instance) {
        super(instance, 241);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("blockFireAlloy", new ItemStack(BlockFireAlloyBlock.block, 1));
    }
}
