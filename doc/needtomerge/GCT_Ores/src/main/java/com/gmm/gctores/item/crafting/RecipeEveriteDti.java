
package com.gmm.gctores.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import com.gmm.gctores.item.ItemEveriteIngot;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemEveriteDust;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class RecipeEveriteDti extends ElementsGctOresMod.ModElement
{
    public RecipeEveriteDti(final ElementsGctOresMod instance) {
        super(instance, 375);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        GameRegistry.addSmelting(new ItemStack(ItemEveriteDust.block, 1), new ItemStack(ItemEveriteIngot.block, 1), 1.0f);
    }
}
