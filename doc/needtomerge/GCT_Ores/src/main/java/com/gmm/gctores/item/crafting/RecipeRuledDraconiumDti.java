
package com.gmm.gctores.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import com.gmm.gctores.item.ItemRuledDraconiumIngot;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemRuledDraconiumDust;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class RecipeRuledDraconiumDti extends ElementsGctOresMod.ModElement
{
    public RecipeRuledDraconiumDti(final ElementsGctOresMod instance) {
        super(instance, 335);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        GameRegistry.addSmelting(new ItemStack(ItemRuledDraconiumDust.block, 1), new ItemStack(ItemRuledDraconiumIngot.block, 1), 1.0f);
    }
}
