
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemSkyAlloyDust;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictDustSkyAlloy extends ElementsGctOresMod.ModElement
{
    public OreDictDustSkyAlloy(final ElementsGctOresMod instance) {
        super(instance, 118);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("dustSkyAlloy", new ItemStack(ItemSkyAlloyDust.block, 1));
    }
}
