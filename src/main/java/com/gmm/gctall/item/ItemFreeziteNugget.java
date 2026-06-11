
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemFreeziteNugget extends Item {
    public static final Item block = new ItemFreeziteNugget();

    public ItemFreeziteNugget() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("freezite_nugget");
        this.setRegistryName("freezite_nugget");
        this.setCreativeTab(TabCTab.tab);

    }
}
