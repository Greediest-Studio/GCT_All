
package com.gmm.gctall.item;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemEveriteGear extends Item {
    public static final Item block = new ItemEveriteGear();

    public ItemEveriteGear() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("everite_gear");
        this.setRegistryName("everite_gear");
        this.setCreativeTab(TabCTab.tab);

    }
@SideOnly(Side.CLIENT)
    public boolean hasEffect(final ItemStack itemstack) {
    return true;
    }

}
