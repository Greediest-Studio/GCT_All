
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemEquipmentWitheriumNugget;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictNuggetEquipmentWitherium extends ElementsGctOresMod.ModElement
{
    public OreDictNuggetEquipmentWitherium(final ElementsGctOresMod instance) {
        super(instance, 264);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("nuggetWitheriumEquipment", new ItemStack(ItemEquipmentWitheriumNugget.block, 1));
    }
}
