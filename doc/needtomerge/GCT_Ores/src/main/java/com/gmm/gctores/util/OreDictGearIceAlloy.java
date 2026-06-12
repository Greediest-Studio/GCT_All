
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemIceAlloyGear;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictGearIceAlloy extends ElementsGctOresMod.ModElement
{
    public OreDictGearIceAlloy(final ElementsGctOresMod instance) {
        super(instance, 475);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("gearIceAlloy", new ItemStack(ItemIceAlloyGear.block, 1));
    }
}
