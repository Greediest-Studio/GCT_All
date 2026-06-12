
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemFallenMetalPlate;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictPlateFallenMetal extends ElementsGctOresMod.ModElement
{
    public OreDictPlateFallenMetal(final ElementsGctOresMod instance) {
        super(instance, 444);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("plateFallenMetal", new ItemStack(ItemFallenMetalPlate.block, 1));
    }
}
