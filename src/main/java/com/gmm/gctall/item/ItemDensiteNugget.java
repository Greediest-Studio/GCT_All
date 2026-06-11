
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemDensiteNugget extends Item {
    public static final Item block = new ItemDensiteNugget();

    public ItemDensiteNugget() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("densite_nugget");
        this.setRegistryName("densite_nugget");
        this.setCreativeTab(TabCTab.tab);

    }
}
