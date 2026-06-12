
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemEquipmentWitheriumPlate;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictPlateEquipmentWitherium extends ElementsGctOresMod.ModElement
{
    public OreDictPlateEquipmentWitherium(final ElementsGctOresMod instance) {
        super(instance, 270);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("plateWitheriumEquipment", new ItemStack(ItemEquipmentWitheriumPlate.block, 1));
    }
}
