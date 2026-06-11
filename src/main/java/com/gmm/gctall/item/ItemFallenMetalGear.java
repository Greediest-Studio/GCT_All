
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTabWitheric;
import net.minecraft.item.Item;

public class ItemFallenMetalGear extends Item {
    public static final Item block = new ItemFallenMetalGear();

    public ItemFallenMetalGear() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("fallen_metal_gear");
        this.setRegistryName("fallen_metal_gear");
        this.setCreativeTab(TabCTabWitheric.tab);

    }
}
