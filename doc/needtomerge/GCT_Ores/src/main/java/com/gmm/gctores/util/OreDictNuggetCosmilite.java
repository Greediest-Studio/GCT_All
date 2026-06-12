
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemCosmiliteNugget;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictNuggetCosmilite extends ElementsGctOresMod.ModElement
{
    public OreDictNuggetCosmilite(final ElementsGctOresMod instance) {
        super(instance, 406);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("nuggetCosmilite", new ItemStack(ItemCosmiliteNugget.block, 1));
    }
}
