
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemFireAlloyNugget;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictNuggetFireAlloy extends ElementsGctOresMod.ModElement
{
    public OreDictNuggetFireAlloy(final ElementsGctOresMod instance) {
        super(instance, 201);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("nuggetFireAlloy", new ItemStack(ItemFireAlloyNugget.block, 1));
    }
}
