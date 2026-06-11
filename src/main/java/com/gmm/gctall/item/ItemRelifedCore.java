
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTabWitheric;
import net.minecraft.item.Item;

public class ItemRelifedCore extends Item {
    public static final Item block = new ItemRelifedCore();

    public ItemRelifedCore() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("relifed_core");
        this.setRegistryName("relifed_core");
        this.setCreativeTab(TabCTabWitheric.tab);

    }
}
