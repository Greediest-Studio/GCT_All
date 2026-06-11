
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemReditriteNugget extends Item {
    public static final Item block = new ItemReditriteNugget();

    public ItemReditriteNugget() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("reditrite_nugget");
        this.setRegistryName("reditrite_nugget");
        this.setCreativeTab(TabCTab.tab);

    }
}
