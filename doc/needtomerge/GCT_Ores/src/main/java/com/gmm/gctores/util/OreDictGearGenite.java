
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemGeniteGear;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictGearGenite extends ElementsGctOresMod.ModElement
{
    public OreDictGearGenite(final ElementsGctOresMod instance) {
        super(instance, 495);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("gearGenite", new ItemStack(ItemGeniteGear.block, 1));
    }
}
