
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.block.BlockBalancedMatrixBlock;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictBlockBalancedMatrix extends ElementsGctOresMod.ModElement
{
    public OreDictBlockBalancedMatrix(final ElementsGctOresMod instance) {
        super(instance, 519);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("blockBalancedMatrix", new ItemStack(BlockBalancedMatrixBlock.block, 1));
    }
}
