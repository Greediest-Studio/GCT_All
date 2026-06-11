
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemDensiteGear extends Item {
    public static final Item block = new ItemDensiteGear();

    public ItemDensiteGear() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("densite_gear");
        this.setRegistryName("densite_gear");
        this.setCreativeTab(TabCTab.tab);

    }
}
