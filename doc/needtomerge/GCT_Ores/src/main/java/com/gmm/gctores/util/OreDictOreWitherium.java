
package com.gmm.gctores.util;

import com.gmm.gctores.block.BlockWitheriumOreEnd;
import com.gmm.gctores.block.BlockWitheriumOreNether;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.block.BlockWitheriumOreOverworld;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictOreWitherium extends ElementsGctOresMod.ModElement
{
    public OreDictOreWitherium(final ElementsGctOresMod instance) {
        super(instance, 278);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("oreWitherium", new ItemStack(BlockWitheriumOreOverworld.block, 1));
        OreDictionary.registerOre("oreWitherium", new ItemStack(BlockWitheriumOreNether.block, 1));
        OreDictionary.registerOre("oreWitherium", new ItemStack(BlockWitheriumOreEnd.block, 1));
    }
}
