
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemSkyAlloyGear;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictGearSkyAlloy extends ElementsGctOresMod.ModElement
{
    public OreDictGearSkyAlloy(final ElementsGctOresMod instance) {
        super(instance, 481);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("gearSkyAlloy", new ItemStack(ItemSkyAlloyGear.block, 1));
    }
}
