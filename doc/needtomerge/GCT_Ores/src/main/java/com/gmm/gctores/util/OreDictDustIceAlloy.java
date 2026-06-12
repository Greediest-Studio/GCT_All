
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemIceAlloyDust;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictDustIceAlloy extends ElementsGctOresMod.ModElement
{
    public OreDictDustIceAlloy(final ElementsGctOresMod instance) {
        super(instance, 369);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("dustIceAlloy", new ItemStack(ItemIceAlloyDust.block, 1));
    }
}
