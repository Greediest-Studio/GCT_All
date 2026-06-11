
package com.gmm.gctall.item;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemEveritePlate extends Item {
    public static final Item block = new ItemEveritePlate();

    public ItemEveritePlate() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("everite_plate");
        this.setRegistryName("everite_plate");
        this.setCreativeTab(TabCTab.tab);

    }
@SideOnly(Side.CLIENT)
    public boolean hasEffect(final ItemStack itemstack) {
    return true;
    }

}
