
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemIceAlloyGear extends Item {
    public static final Item block = new ItemIceAlloyGear();

    public ItemIceAlloyGear() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("ice_alloy_gear");
        this.setRegistryName("ice_alloy_gear");
        this.setCreativeTab(TabCTab.tab);

    }
}
