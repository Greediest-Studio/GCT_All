
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTabWitheric;
import net.minecraft.item.Item;

public class ItemRelifedMetalGear extends Item {
    public static final Item block = new ItemRelifedMetalGear();

    public ItemRelifedMetalGear() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("relifed_metal_gear");
        this.setRegistryName("relifed_metal_gear");
        this.setCreativeTab(TabCTabWitheric.tab);

    }
}
