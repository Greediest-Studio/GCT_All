
package com.gmm.gctores.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import com.gmm.gctores.item.ItemDensiteIngot;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemDensiteDust;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class RecipeDensiteDti extends ElementsGctOresMod.ModElement
{
    public RecipeDensiteDti(final ElementsGctOresMod instance) {
        super(instance, 248);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        GameRegistry.addSmelting(new ItemStack(ItemDensiteDust.block, 1), new ItemStack(ItemDensiteIngot.block, 1), 1.0f);
    }
}
