
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTabWitheric;
import net.minecraft.item.Item;

public class ItemRelifedMetalIngot extends Item {
    public static final Item block = new ItemRelifedMetalIngot();

    public ItemRelifedMetalIngot() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("relifed_metal_ingot");
        this.setRegistryName("relifed_metal_ingot");
        this.setCreativeTab(TabCTabWitheric.tab);

    }
}
