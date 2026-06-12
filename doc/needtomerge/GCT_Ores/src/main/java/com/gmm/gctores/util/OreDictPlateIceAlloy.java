
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemIceAlloyPlate;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictPlateIceAlloy extends ElementsGctOresMod.ModElement
{
    public OreDictPlateIceAlloy(final ElementsGctOresMod instance) {
        super(instance, 464);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("plateIceAlloy", new ItemStack(ItemIceAlloyPlate.block, 1));
    }
}
