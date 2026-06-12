
package com.gmm.gctores.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import com.gmm.gctores.item.ItemChaoticDraconiumIngot;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemChaoticDraconiumDust;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class RecipeChaoticDraconiumDti extends ElementsGctOresMod.ModElement
{
    public RecipeChaoticDraconiumDti(final ElementsGctOresMod instance) {
        super(instance, 247);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        GameRegistry.addSmelting(new ItemStack(ItemChaoticDraconiumDust.block, 1), new ItemStack(ItemChaoticDraconiumIngot.block, 1), 1.0f);
    }
}
