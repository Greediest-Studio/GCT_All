
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTabWitheric;
import net.minecraft.item.Item;

public class ItemWithericCore extends Item {
    public static final Item block = new ItemWithericCore();

    public ItemWithericCore() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("witheric_core");
        this.setRegistryName("witheric_core");
        this.setCreativeTab(TabCTabWitheric.tab);

    }
}
