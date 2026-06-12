
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemBalancedMatrixIngot;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictIngotBalancedMatrix extends ElementsGctOresMod.ModElement
{
    public OreDictIngotBalancedMatrix(final ElementsGctOresMod instance) {
        super(instance, 504);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("ingotBalancedMatrix", new ItemStack(ItemBalancedMatrixIngot.block, 1));
    }
}
