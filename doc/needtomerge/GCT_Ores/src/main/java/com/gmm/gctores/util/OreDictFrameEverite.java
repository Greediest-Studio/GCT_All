
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.block.BlockEveriteMachineFrame;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictFrameEverite extends ElementsGctOresMod.ModElement
{
    public OreDictFrameEverite(final ElementsGctOresMod instance) {
        super(instance, 502);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("frameEverite", new ItemStack(BlockEveriteMachineFrame.block, 1));
    }
}
