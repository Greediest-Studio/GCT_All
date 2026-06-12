
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemOrderCrystal;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictGemOrderCrystal extends ElementsGctOresMod.ModElement
{
    public OreDictGemOrderCrystal(final ElementsGctOresMod instance) {
        super(instance, 373);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("gemOrderCrystal", new ItemStack(ItemOrderCrystal.block, 1));
    }
}
