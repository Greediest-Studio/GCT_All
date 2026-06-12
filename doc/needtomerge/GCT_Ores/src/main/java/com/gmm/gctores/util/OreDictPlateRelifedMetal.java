
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemRelifedMetalPlate;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictPlateRelifedMetal extends ElementsGctOresMod.ModElement
{
    public OreDictPlateRelifedMetal(final ElementsGctOresMod instance) {
        super(instance, 445);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("plateRelifedMetal", new ItemStack(ItemRelifedMetalPlate.block, 1));
    }
}
