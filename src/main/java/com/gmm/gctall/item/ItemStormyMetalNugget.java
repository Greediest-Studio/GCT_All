
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTabWitheric;
import net.minecraft.item.Item;

public class ItemStormyMetalNugget extends Item {
    public static final Item block = new ItemStormyMetalNugget();

    public ItemStormyMetalNugget() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("stormy_metal_nugget");
        this.setRegistryName("stormy_metal_nugget");
        this.setCreativeTab(TabCTabWitheric.tab);

    }
}
