
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemCosmiliteNugget extends Item {
    public static final Item block = new ItemCosmiliteNugget();

    public ItemCosmiliteNugget() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("cosmilite_nugget");
        this.setRegistryName("cosmilite_nugget");
        this.setCreativeTab(TabCTab.tab);

    }
}
