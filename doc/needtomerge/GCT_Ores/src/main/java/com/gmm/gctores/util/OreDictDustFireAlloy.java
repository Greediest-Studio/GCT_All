
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemFireAlloyDust;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictDustFireAlloy extends ElementsGctOresMod.ModElement
{
    public OreDictDustFireAlloy(final ElementsGctOresMod instance) {
        super(instance, 206);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("dustFireAlloy", new ItemStack(ItemFireAlloyDust.block, 1));
    }
}
