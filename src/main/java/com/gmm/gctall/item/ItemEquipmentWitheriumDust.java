
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTabWitheric;
import net.minecraft.item.Item;

public class ItemEquipmentWitheriumDust extends Item {
    public static final Item block = new ItemEquipmentWitheriumDust();

    public ItemEquipmentWitheriumDust() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("equipment_witherium_dust");
        this.setRegistryName("equipment_witherium_dust");
        this.setCreativeTab(TabCTabWitheric.tab);

    }
}
