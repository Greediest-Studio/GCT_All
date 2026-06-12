
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemFinalliumIngot;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictIngotFinallium extends ElementsGctOresMod.ModElement
{
    public OreDictIngotFinallium(final ElementsGctOresMod instance) {
        super(instance, 288);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("ingotFinallium", new ItemStack(ItemFinalliumIngot.block, 1));
    }
}
