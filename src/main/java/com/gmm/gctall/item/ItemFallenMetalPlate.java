
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTabWitheric;
import net.minecraft.item.Item;

public class ItemFallenMetalPlate extends Item {
    public static final Item block = new ItemFallenMetalPlate();

    public ItemFallenMetalPlate() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("fallen_metal_plate");
        this.setRegistryName("fallen_metal_plate");
        this.setCreativeTab(TabCTabWitheric.tab);

    }
}
