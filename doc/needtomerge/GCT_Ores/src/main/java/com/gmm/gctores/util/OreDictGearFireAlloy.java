
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemFireAlloyGear;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictGearFireAlloy extends ElementsGctOresMod.ModElement
{
    public OreDictGearFireAlloy(final ElementsGctOresMod instance) {
        super(instance, 472);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("gearFireAlloy", new ItemStack(ItemFireAlloyGear.block, 1));
    }
}
