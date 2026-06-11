
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemFireAlloyGear extends Item {
    public static final Item block = new ItemFireAlloyGear();

    public ItemFireAlloyGear() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("fire_alloy_gear");
        this.setRegistryName("fire_alloy_gear");
        this.setCreativeTab(TabCTab.tab);

    }
}
