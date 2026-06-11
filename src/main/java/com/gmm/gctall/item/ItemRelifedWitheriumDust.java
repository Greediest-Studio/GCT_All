
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTabWitheric;
import net.minecraft.item.Item;

public class ItemRelifedWitheriumDust extends Item {
    public static final Item block = new ItemRelifedWitheriumDust();

    public ItemRelifedWitheriumDust() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("relifed_witherium_dust");
        this.setRegistryName("relifed_witherium_dust");
        this.setCreativeTab(TabCTabWitheric.tab);

    }
}
