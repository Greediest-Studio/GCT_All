
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemCanopiumNugget extends Item {
    public static final Item block = new ItemCanopiumNugget();

    public ItemCanopiumNugget() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("canopium_nugget");
        this.setRegistryName("canopium_nugget");
        this.setCreativeTab(TabCTab.tab);

    }
}
