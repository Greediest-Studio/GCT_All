
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemStormyWitheriumDust;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictDustStormyWitherium extends ElementsGctOresMod.ModElement
{
    public OreDictDustStormyWitherium(final ElementsGctOresMod instance) {
        super(instance, 284);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("dustWitheriumStormy", new ItemStack(ItemStormyWitheriumDust.block, 1));
    }
}
