
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemFireAlloyPlate extends Item {
    public static final Item block = new ItemFireAlloyPlate();

    public ItemFireAlloyPlate() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("fire_alloy_plate");
        this.setRegistryName("fire_alloy_plate");
        this.setCreativeTab(TabCTab.tab);

    }
}
