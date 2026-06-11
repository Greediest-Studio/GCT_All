
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTabWitheric;
import net.minecraft.item.Item;

public class ItemStormyWitheriumNugget extends Item {
    public static final Item block = new ItemStormyWitheriumNugget();

    public ItemStormyWitheriumNugget() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("stormy_witherium_nugget");
        this.setRegistryName("stormy_witherium_nugget");
        this.setCreativeTab(TabCTabWitheric.tab);

    }
}
