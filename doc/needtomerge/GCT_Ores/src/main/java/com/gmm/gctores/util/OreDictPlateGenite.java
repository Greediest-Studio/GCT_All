
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemGenitePlate;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictPlateGenite extends ElementsGctOresMod.ModElement
{
    public OreDictPlateGenite(final ElementsGctOresMod instance) {
        super(instance, 493);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("plateGenite", new ItemStack(ItemGenitePlate.block, 1));
    }
}
