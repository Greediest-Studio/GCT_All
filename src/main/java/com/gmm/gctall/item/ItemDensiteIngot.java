
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemDensiteIngot extends Item {
    public static final Item block = new ItemDensiteIngot();

    public ItemDensiteIngot() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("densite_ingot");
        this.setRegistryName("densite_ingot");
        this.setCreativeTab(TabCTab.tab);

    }
}
