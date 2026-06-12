
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemStormyMetalDust;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictDustStormyMetal extends ElementsGctOresMod.ModElement
{
    public OreDictDustStormyMetal(final ElementsGctOresMod instance) {
        super(instance, 438);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("dustStormyMetal", new ItemStack(ItemStormyMetalDust.block, 1));
    }
}
