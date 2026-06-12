
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemCommandCore;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictCoreCommand extends ElementsGctOresMod.ModElement
{
    public OreDictCoreCommand(final ElementsGctOresMod instance) {
        super(instance, 288);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("coreCommand", new ItemStack(ItemCommandCore.block, 1));
    }
}
