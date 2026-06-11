
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemGeniteGear extends Item {
    public static final Item block = new ItemGeniteGear();

    public ItemGeniteGear() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("genite_gear");
        this.setRegistryName("genite_gear");
        this.setCreativeTab(TabCTab.tab);

    }
}
