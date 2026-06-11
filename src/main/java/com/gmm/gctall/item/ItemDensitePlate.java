
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemDensitePlate extends Item {
    public static final Item block = new ItemDensitePlate();

    public ItemDensitePlate() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("densite_plate");
        this.setRegistryName("densite_plate");
        this.setCreativeTab(TabCTab.tab);

    }
}
