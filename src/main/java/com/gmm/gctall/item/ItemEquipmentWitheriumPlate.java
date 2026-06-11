
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTabWitheric;
import net.minecraft.item.Item;

public class ItemEquipmentWitheriumPlate extends Item {
    public static final Item block = new ItemEquipmentWitheriumPlate();

    public ItemEquipmentWitheriumPlate() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("equipment_witherium_plate");
        this.setRegistryName("equipment_witherium_plate");
        this.setCreativeTab(TabCTabWitheric.tab);

    }
}
