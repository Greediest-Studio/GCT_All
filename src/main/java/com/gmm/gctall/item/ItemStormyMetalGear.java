
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTabWitheric;
import net.minecraft.item.Item;

public class ItemStormyMetalGear extends Item {
    public static final Item block = new ItemStormyMetalGear();

    public ItemStormyMetalGear() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("stormy_metal_gear");
        this.setRegistryName("stormy_metal_gear");
        this.setCreativeTab(TabCTabWitheric.tab);

    }
}
