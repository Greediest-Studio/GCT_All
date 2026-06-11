
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemGeniteDust extends Item {
    public static final Item block = new ItemGeniteDust();

    public ItemGeniteDust() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("genite_dust");
        this.setRegistryName("genite_dust");
        this.setCreativeTab(TabCTab.tab);

    }
}
