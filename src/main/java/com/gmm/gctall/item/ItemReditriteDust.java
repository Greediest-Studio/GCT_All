
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemReditriteDust extends Item {
    public static final Item block = new ItemReditriteDust();

    public ItemReditriteDust() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("reditrite_dust");
        this.setRegistryName("reditrite_dust");
        this.setCreativeTab(TabCTab.tab);

    }
}
