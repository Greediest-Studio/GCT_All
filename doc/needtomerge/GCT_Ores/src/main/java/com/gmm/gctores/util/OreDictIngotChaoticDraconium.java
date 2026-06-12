
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemChaoticDraconiumIngot;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictIngotChaoticDraconium extends ElementsGctOresMod.ModElement
{
    public OreDictIngotChaoticDraconium(final ElementsGctOresMod instance) {
        super(instance, 30);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("ingotDraconiumChaotic", new ItemStack(ItemChaoticDraconiumIngot.block, 1));
    }
}
