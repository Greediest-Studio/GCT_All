
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.block.BlockGeniteMachineFrame;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictFrameGenite extends ElementsGctOresMod.ModElement
{
    public OreDictFrameGenite(final ElementsGctOresMod instance) {
        super(instance, 499);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("frameGenite", new ItemStack(BlockGeniteMachineFrame.block, 1));
    }
}
