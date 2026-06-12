
package com.gmm.gctores.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import com.gmm.gctores.item.ItemReditriteIngot;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemReditriteDust;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class RecipeReditriteDti extends ElementsGctOresMod.ModElement
{
    public RecipeReditriteDti(final ElementsGctOresMod instance) {
        super(instance, 249);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        GameRegistry.addSmelting(new ItemStack(ItemReditriteDust.block, 1), new ItemStack(ItemReditriteIngot.block, 1), 1.0f);
    }
}
