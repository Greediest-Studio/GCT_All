
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemSkyAlloyIngot extends Item {
    public static final Item block = new ItemSkyAlloyIngot();

    public ItemSkyAlloyIngot() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("sky_alloy_ingot");
        this.setRegistryName("sky_alloy_ingot");
        this.setCreativeTab(TabCTab.tab);

    }
}
