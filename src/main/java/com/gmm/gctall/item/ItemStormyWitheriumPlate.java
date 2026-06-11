
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTabWitheric;
import net.minecraft.item.Item;

public class ItemStormyWitheriumPlate extends Item {
    public static final Item block = new ItemStormyWitheriumPlate();

    public ItemStormyWitheriumPlate() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("stormy_witherium_plate");
        this.setRegistryName("stormy_witherium_plate");
        this.setCreativeTab(TabCTabWitheric.tab);

    }
}
