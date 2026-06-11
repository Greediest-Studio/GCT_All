
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemIceAlloyPlate extends Item {
    public static final Item block = new ItemIceAlloyPlate();

    public ItemIceAlloyPlate() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("ice_alloy_plate");
        this.setRegistryName("ice_alloy_plate");
        this.setCreativeTab(TabCTab.tab);

    }
}
