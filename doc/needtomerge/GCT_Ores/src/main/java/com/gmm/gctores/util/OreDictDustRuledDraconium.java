
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemRuledDraconiumDust;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictDustRuledDraconium extends ElementsGctOresMod.ModElement
{
    public OreDictDustRuledDraconium(final ElementsGctOresMod instance) {
        super(instance, 249);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("dustDraconiumRuled", new ItemStack(ItemRuledDraconiumDust.block, 1));
    }
}
