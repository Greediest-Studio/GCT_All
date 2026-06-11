
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemMistiumNugget extends Item {
    public static final Item block = new ItemMistiumNugget();

    public ItemMistiumNugget() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("mistium_nugget");
        this.setRegistryName("mistium_nugget");
        this.setCreativeTab(TabCTab.tab);

    }
}
