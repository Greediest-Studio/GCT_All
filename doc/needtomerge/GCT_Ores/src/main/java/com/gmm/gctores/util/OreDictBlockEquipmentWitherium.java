
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.block.BlockEquipmentWitheriumBlock;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictBlockEquipmentWitherium extends ElementsGctOresMod.ModElement
{
    public OreDictBlockEquipmentWitherium(final ElementsGctOresMod instance) {
        super(instance, 261);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("blockWitheriumEquipment", new ItemStack(BlockEquipmentWitheriumBlock.block, 1));
    }
}
