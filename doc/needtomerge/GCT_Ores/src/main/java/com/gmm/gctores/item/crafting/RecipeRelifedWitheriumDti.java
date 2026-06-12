
package com.gmm.gctores.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import com.gmm.gctores.item.ItemRelifedWitheriumIngot;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemRelifedWitheriumDust;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class RecipeRelifedWitheriumDti extends ElementsGctOresMod.ModElement
{
    public RecipeRelifedWitheriumDti(final ElementsGctOresMod instance) {
        super(instance, 388);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        GameRegistry.addSmelting(new ItemStack(ItemRelifedWitheriumDust.block, 1), new ItemStack(ItemRelifedWitheriumIngot.block, 1), 1.0f);
    }
}
