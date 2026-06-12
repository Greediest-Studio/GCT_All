
package com.gmm.gctores.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import com.gmm.gctores.item.ItemStormyWitheriumIngot;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemStormyWitheriumDust;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class RecipeStormyWitheriumDti extends ElementsGctOresMod.ModElement
{
    public RecipeStormyWitheriumDti(final ElementsGctOresMod instance) {
        super(instance, 389);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        GameRegistry.addSmelting(new ItemStack(ItemStormyWitheriumDust.block, 1), new ItemStack(ItemStormyWitheriumIngot.block, 1), 1.0f);
    }
}
