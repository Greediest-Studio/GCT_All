
package com.gmm.gctores.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.item.ItemHermaphroditicArtifact;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class OreDictGemHermaphroditic extends ElementsGctOresMod.ModElement
{
    public OreDictGemHermaphroditic(final ElementsGctOresMod instance) {
        super(instance, 375);
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        OreDictionary.registerOre("gemHermaphroditic", new ItemStack(ItemHermaphroditicArtifact.block, 1));
    }
}
