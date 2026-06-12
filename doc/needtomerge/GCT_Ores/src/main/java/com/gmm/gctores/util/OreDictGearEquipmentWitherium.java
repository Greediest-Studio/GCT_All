
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemEquipmentWitheriumGear;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictGearEquipmentWitherium extends ElementsGctOresMod.ModElement
{
    public OreDictGearEquipmentWitherium(final ElementsGctOresMod instance) {
        super(instance, 267);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("gearWitheriumEquipment", new ItemStack(ItemEquipmentWitheriumGear.block, 1));
    }
}
