
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemAdeniniteNugget extends Item {
    public static final Item block = new ItemAdeniniteNugget();

    public ItemAdeniniteNugget() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("adeninite_nugget");
        this.setRegistryName("adeninite_nugget");
        this.setCreativeTab(TabCTab.tab);

    }
}
