
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemGeniteDust;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictDustGenite extends ElementsGctOresMod.ModElement
{
    public OreDictDustGenite(final ElementsGctOresMod instance) {
        super(instance, 492);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("dustGenite", new ItemStack(ItemGeniteDust.block, 1));
    }
}
