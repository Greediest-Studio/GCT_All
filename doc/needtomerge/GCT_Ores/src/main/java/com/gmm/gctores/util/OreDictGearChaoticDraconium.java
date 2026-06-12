
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemChaoticDraconiumGear;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictGearChaoticDraconium extends ElementsGctOresMod.ModElement
{
    public OreDictGearChaoticDraconium(final ElementsGctOresMod instance) {
        super(instance, 470);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("gearDraconiumChaotic", new ItemStack(ItemChaoticDraconiumGear.block, 1));
    }
}
