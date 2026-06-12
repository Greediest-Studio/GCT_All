
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemGeniteIngot;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictIngotGenite extends ElementsGctOresMod.ModElement
{
    public OreDictIngotGenite(final ElementsGctOresMod instance) {
        super(instance, 492);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("ingotGenite", new ItemStack(ItemGeniteIngot.block, 1));
    }
}
