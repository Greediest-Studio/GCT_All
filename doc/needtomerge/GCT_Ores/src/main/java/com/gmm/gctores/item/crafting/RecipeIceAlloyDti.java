
package com.gmm.gctores.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import com.gmm.gctores.item.ItemIceAlloyIngot;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemIceAlloyDust;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class RecipeIceAlloyDti extends ElementsGctOresMod.ModElement
{
    public RecipeIceAlloyDti(final ElementsGctOresMod instance) {
        super(instance, 374);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        GameRegistry.addSmelting(new ItemStack(ItemIceAlloyDust.block, 1), new ItemStack(ItemIceAlloyIngot.block, 1), 1.0f);
    }
}
