
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemReditritePlate extends Item {
    public static final Item block = new ItemReditritePlate();

    public ItemReditritePlate() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("reditrite_plate");
        this.setRegistryName("reditrite_plate");
        this.setCreativeTab(TabCTab.tab);

    }
}
