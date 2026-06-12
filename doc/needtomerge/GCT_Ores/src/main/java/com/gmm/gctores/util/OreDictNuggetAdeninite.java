
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemAdeniniteNugget;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictNuggetAdeninite extends ElementsGctOresMod.ModElement
{
    public OreDictNuggetAdeninite(final ElementsGctOresMod instance) {
        super(instance, 355);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("nuggetAdeninite", new ItemStack(ItemAdeniniteNugget.block, 1));
    }
}
