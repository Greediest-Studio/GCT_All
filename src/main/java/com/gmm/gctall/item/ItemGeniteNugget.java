
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemGeniteNugget extends Item {
    public static final Item block = new ItemGeniteNugget();

    public ItemGeniteNugget() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("genite_nugget");
        this.setRegistryName("genite_nugget");
        this.setCreativeTab(TabCTab.tab);

    }
}
