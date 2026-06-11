
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemBnightiumNugget extends Item {
    public static final Item block = new ItemBnightiumNugget();

    public ItemBnightiumNugget() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("bnightium_nugget");
        this.setRegistryName("bnightium_nugget");
        this.setCreativeTab(TabCTab.tab);

    }
}
