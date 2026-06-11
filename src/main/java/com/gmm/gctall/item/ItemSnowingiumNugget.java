
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemSnowingiumNugget extends Item {
    public static final Item block = new ItemSnowingiumNugget();

    public ItemSnowingiumNugget() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("snowingium_nugget");
        this.setRegistryName("snowingium_nugget");
        this.setCreativeTab(TabCTab.tab);

    }
}
