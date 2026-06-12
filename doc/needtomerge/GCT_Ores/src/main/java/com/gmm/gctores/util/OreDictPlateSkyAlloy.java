
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemSkyAlloyPlate;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictPlateSkyAlloy extends ElementsGctOresMod.ModElement
{
    public OreDictPlateSkyAlloy(final ElementsGctOresMod instance) {
        super(instance, 462);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("plateSkyAlloy", new ItemStack(ItemSkyAlloyPlate.block, 1));
    }
}
