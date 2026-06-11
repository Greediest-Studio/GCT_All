
package com.gmm.gctall.item;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemEveriteDust extends Item {
    public static final Item block = new ItemEveriteDust();

    public ItemEveriteDust() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("everite_dust");
        this.setRegistryName("everite_dust");
        this.setCreativeTab(TabCTab.tab);

    }
@SideOnly(Side.CLIENT)
    public boolean hasEffect(final ItemStack itemstack) {
    return true;
    }

}
