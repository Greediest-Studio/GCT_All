
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemEquipmentWitheriumIngot;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictIngotEquipmentWitherium extends ElementsGctOresMod.ModElement
{
    public OreDictIngotEquipmentWitherium(final ElementsGctOresMod instance) {
        super(instance, 241);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("ingotWitheriumEquipment", new ItemStack(ItemEquipmentWitheriumIngot.block, 1));
    }
}
