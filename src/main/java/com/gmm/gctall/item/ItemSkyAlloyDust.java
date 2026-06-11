
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemSkyAlloyDust extends Item {
    public static final Item block = new ItemSkyAlloyDust();

    public ItemSkyAlloyDust() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("sky_alloy_dust");
        this.setRegistryName("sky_alloy_dust");
        this.setCreativeTab(TabCTab.tab);

    }
}
