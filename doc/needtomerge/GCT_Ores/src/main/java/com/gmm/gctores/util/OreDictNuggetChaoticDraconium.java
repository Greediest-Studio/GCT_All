
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemChaoticDraconiumNugget;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictNuggetChaoticDraconium extends ElementsGctOresMod.ModElement
{
    public OreDictNuggetChaoticDraconium(final ElementsGctOresMod instance) {
        super(instance, 136);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("nuggetDraconiumChaotic", new ItemStack(ItemChaoticDraconiumNugget.block, 1));
    }
}
