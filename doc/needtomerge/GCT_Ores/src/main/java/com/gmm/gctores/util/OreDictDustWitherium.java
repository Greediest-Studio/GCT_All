
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemWitheriumDust;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictDustWitherium extends ElementsGctOresMod.ModElement
{
    public OreDictDustWitherium(final ElementsGctOresMod instance) {
        super(instance, 280);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("dustWitherium", new ItemStack(ItemWitheriumDust.block, 1));
    }
}
