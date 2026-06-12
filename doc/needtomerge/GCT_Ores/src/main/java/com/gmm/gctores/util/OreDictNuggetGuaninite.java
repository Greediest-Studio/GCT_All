
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemGuaniniteNugget;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictNuggetGuaninite extends ElementsGctOresMod.ModElement
{
    public OreDictNuggetGuaninite(final ElementsGctOresMod instance) {
        super(instance, 198);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("nuggetGuaninite", new ItemStack(ItemGuaniniteNugget.block, 1));
    }
}
