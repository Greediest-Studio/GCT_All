
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemFreeziteNugget;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictNuggetFreezite extends ElementsGctOresMod.ModElement
{
    public OreDictNuggetFreezite(final ElementsGctOresMod instance) {
        super(instance, 353);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("nuggetFreezite", new ItemStack(ItemFreeziteNugget.block, 1));
    }
}
