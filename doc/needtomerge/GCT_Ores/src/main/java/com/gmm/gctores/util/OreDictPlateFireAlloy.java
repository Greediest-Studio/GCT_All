
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemFireAlloyPlate;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictPlateFireAlloy extends ElementsGctOresMod.ModElement
{
    public OreDictPlateFireAlloy(final ElementsGctOresMod instance) {
        super(instance, 463);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("plateFireAlloy", new ItemStack(ItemFireAlloyPlate.block, 1));
    }
}
