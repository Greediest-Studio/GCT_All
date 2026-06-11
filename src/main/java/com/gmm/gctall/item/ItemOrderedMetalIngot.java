
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTabWitheric;
import net.minecraft.item.Item;

public class ItemOrderedMetalIngot extends Item {
    public static final Item block = new ItemOrderedMetalIngot();

    public ItemOrderedMetalIngot() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("ordered_metal_ingot");
        this.setRegistryName("ordered_metal_ingot");
        this.setCreativeTab(TabCTabWitheric.tab);

    }
}
