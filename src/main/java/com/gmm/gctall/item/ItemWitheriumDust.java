
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTabWitheric;
import net.minecraft.item.Item;

public class ItemWitheriumDust extends Item {
    public static final Item block = new ItemWitheriumDust();

    public ItemWitheriumDust() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("witherium_dust");
        this.setRegistryName("witherium_dust");
        this.setCreativeTab(TabCTabWitheric.tab);

    }
}
