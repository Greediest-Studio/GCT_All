
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemShalloite extends Item {
    public static final Item block = new ItemShalloite();

    public ItemShalloite() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("shalloite");
        this.setRegistryName("shalloite");
        this.setCreativeTab(TabCTab.tab);

    }
}
