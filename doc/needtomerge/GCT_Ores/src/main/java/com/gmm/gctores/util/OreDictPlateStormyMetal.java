
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemStormyMetalPlate;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictPlateStormyMetal extends ElementsGctOresMod.ModElement
{
    public OreDictPlateStormyMetal(final ElementsGctOresMod instance) {
        super(instance, 446);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("plateStormyMetal", new ItemStack(ItemStormyMetalPlate.block, 1));
    }
}
