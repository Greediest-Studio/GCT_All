
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTabWitheric;
import net.minecraft.item.Item;

public class ItemRelifedWitheriumGear extends Item {
    public static final Item block = new ItemRelifedWitheriumGear();

    public ItemRelifedWitheriumGear() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("relifed_witherium_gear");
        this.setRegistryName("relifed_witherium_gear");
        this.setCreativeTab(TabCTabWitheric.tab);

    }
}
