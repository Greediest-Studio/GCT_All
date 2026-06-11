
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemIceAlloyIngot extends Item {
    public static final Item block = new ItemIceAlloyIngot();

    public ItemIceAlloyIngot() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("ice_alloy_ingot");
        this.setRegistryName("ice_alloy_ingot");
        this.setCreativeTab(TabCTab.tab);

    }
}
