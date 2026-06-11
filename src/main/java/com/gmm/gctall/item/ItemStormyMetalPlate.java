
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTabWitheric;
import net.minecraft.item.Item;

public class ItemStormyMetalPlate extends Item {
    public static final Item block = new ItemStormyMetalPlate();

    public ItemStormyMetalPlate() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("stormy_metal_plate");
        this.setRegistryName("stormy_metal_plate");
        this.setCreativeTab(TabCTabWitheric.tab);

    }
}
