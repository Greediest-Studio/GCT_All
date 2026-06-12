
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemFireAlloyIngot;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictIngotFireAlloy extends ElementsGctOresMod.ModElement
{
    public OreDictIngotFireAlloy(final ElementsGctOresMod instance) {
        super(instance, 196);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("ingotFireAlloy", new ItemStack(ItemFireAlloyIngot.block, 1));
    }
}
