
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemThyminiteNugget extends Item {
    public static final Item block = new ItemThyminiteNugget();

    public ItemThyminiteNugget() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("thyminite_nugget");
        this.setRegistryName("thyminite_nugget");
        this.setCreativeTab(TabCTab.tab);

    }
}
