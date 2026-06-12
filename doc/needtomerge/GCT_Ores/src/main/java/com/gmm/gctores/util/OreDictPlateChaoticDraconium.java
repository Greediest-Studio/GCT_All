
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemChaoticDraconiumPlate;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictPlateChaoticDraconium extends ElementsGctOresMod.ModElement
{
    public OreDictPlateChaoticDraconium(final ElementsGctOresMod instance) {
        super(instance, 460);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("plateDraconiumChaotic", new ItemStack(ItemChaoticDraconiumPlate.block, 1));
    }
}
