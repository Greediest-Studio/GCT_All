
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemStormyShard;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictGemStormyShard extends ElementsGctOresMod.ModElement
{
    public OreDictGemStormyShard(final ElementsGctOresMod instance) {
        super(instance, 320);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("gemStormyShard", new ItemStack(ItemStormyShard.block, 1));
    }
}
