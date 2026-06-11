
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemSkyAlloyNugget extends Item {
    public static final Item block = new ItemSkyAlloyNugget();

    public ItemSkyAlloyNugget() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("sky_alloy_nugget");
        this.setRegistryName("sky_alloy_nugget");
        this.setCreativeTab(TabCTab.tab);

    }
}
