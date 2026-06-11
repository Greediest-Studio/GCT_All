
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemHermaphroditicArtifact extends Item {
    public static final Item block = new ItemHermaphroditicArtifact();

    public ItemHermaphroditicArtifact() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("hermaphroditic_artifact");
        this.setRegistryName("hermaphroditic_artifact");
        this.setCreativeTab(TabCTab.tab);

    }
}
