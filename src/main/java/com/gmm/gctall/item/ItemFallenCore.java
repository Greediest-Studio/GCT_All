
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTabWitheric;
import net.minecraft.item.Item;

public class ItemFallenCore extends Item {
    public static final Item block = new ItemFallenCore();

    public ItemFallenCore() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("fallen_core");
        this.setRegistryName("fallen_core");
        this.setCreativeTab(TabCTabWitheric.tab);

    }
}
