
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemLavariteNugget extends Item {
    public static final Item block = new ItemLavariteNugget();

    public ItemLavariteNugget() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("lavarite_nugget");
        this.setRegistryName("lavarite_nugget");
        this.setCreativeTab(TabCTab.tab);

    }
}
