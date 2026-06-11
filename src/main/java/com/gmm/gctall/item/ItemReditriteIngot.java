
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemReditriteIngot extends Item {
    public static final Item block = new ItemReditriteIngot();

    public ItemReditriteIngot() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("reditrite_ingot");
        this.setRegistryName("reditrite_ingot");
        this.setCreativeTab(TabCTab.tab);

    }
}
