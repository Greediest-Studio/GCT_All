
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemPhotovoltaicCellXI extends Item {
    public static final Item block = new ItemPhotovoltaicCellXI();

    public ItemPhotovoltaicCellXI() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("photovoltaic_cell_xi");
        this.setRegistryName("photovoltaic_cell_xi");
        this.setCreativeTab(TabCTab.tab);

    }
}
