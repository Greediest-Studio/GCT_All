
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemChaoticDraconiumDust;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictDustChaoticDraconium extends ElementsGctOresMod.ModElement
{
    public OreDictDustChaoticDraconium(final ElementsGctOresMod instance) {
        super(instance, 114);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("dustDraconiumChaotic", new ItemStack(ItemChaoticDraconiumDust.block, 1));
    }
}
