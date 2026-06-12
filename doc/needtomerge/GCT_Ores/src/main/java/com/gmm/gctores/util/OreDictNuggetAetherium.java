
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemAetheriumNugget;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictNuggetAetherium extends ElementsGctOresMod.ModElement
{
    public OreDictNuggetAetherium(final ElementsGctOresMod instance) {
        super(instance, 32);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("nuggetAetherium", new ItemStack(ItemAetheriumNugget.block, 1));
    }
}
