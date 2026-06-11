
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemBalancedMatrixIngot extends Item {
    public static final Item block = new ItemBalancedMatrixIngot();

    public ItemBalancedMatrixIngot() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("balanced_matrix_ingot");
        this.setRegistryName("balanced_matrix_ingot");
        this.setCreativeTab(TabCTab.tab);

    }
}
