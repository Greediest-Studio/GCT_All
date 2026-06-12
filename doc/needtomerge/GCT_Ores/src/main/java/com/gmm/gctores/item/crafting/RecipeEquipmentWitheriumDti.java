
package com.gmm.gctores.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import com.gmm.gctores.item.ItemEquipmentWitheriumIngot;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemEquipmentWitheriumDust;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class RecipeEquipmentWitheriumDti extends ElementsGctOresMod.ModElement
{
    public RecipeEquipmentWitheriumDti(final ElementsGctOresMod instance) {
        super(instance, 390);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        GameRegistry.addSmelting(new ItemStack(ItemEquipmentWitheriumDust.block, 1), new ItemStack(ItemEquipmentWitheriumIngot.block, 1), 1.0f);
    }
}
