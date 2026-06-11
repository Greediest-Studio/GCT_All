
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemPhotovoltaicCellVII extends Item {
    public static final Item block = new ItemPhotovoltaicCellVII();

    public ItemPhotovoltaicCellVII() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("photovoltaic_cell_vii");
        this.setRegistryName("photovoltaic_cell_vii");
        this.setCreativeTab(TabCTab.tab);

    }
}
