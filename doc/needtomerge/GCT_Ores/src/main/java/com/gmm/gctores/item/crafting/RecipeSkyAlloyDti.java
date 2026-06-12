
package com.gmm.gctores.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import com.gmm.gctores.item.ItemSkyAlloyIngot;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemSkyAlloyDust;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class RecipeSkyAlloyDti extends ElementsGctOresMod.ModElement
{
    public RecipeSkyAlloyDti(final ElementsGctOresMod instance) {
        super(instance, 250);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        GameRegistry.addSmelting(new ItemStack(ItemSkyAlloyDust.block, 1), new ItemStack(ItemSkyAlloyIngot.block, 1), 1.0f);
    }
}
