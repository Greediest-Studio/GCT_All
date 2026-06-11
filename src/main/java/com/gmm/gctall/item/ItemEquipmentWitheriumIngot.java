
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTabWitheric;
import net.minecraft.item.Item;

public class ItemEquipmentWitheriumIngot extends Item {
    public static final Item block = new ItemEquipmentWitheriumIngot();

    public ItemEquipmentWitheriumIngot() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("equipment_witherium_ingot");
        this.setRegistryName("equipment_witherium_ingot");
        this.setCreativeTab(TabCTabWitheric.tab);

    }
}
