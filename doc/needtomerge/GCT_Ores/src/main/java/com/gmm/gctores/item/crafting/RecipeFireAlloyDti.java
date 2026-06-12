
package com.gmm.gctores.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import com.gmm.gctores.item.ItemFireAlloyIngot;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemFireAlloyDust;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class RecipeFireAlloyDti extends ElementsGctOresMod.ModElement
{
    public RecipeFireAlloyDti(final ElementsGctOresMod instance) {
        super(instance, 260);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        GameRegistry.addSmelting(new ItemStack(ItemFireAlloyDust.block, 1), new ItemStack(ItemFireAlloyIngot.block, 1), 1.0f);
    }
}
