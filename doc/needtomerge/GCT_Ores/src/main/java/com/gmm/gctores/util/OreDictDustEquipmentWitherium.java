
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemEquipmentWitheriumDust;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictDustEquipmentWitherium extends ElementsGctOresMod.ModElement
{
    public OreDictDustEquipmentWitherium(final ElementsGctOresMod instance) {
        super(instance, 285);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("dustWitheriumEquipment", new ItemStack(ItemEquipmentWitheriumDust.block, 1));
    }
}
