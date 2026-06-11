
package com.gmm.gctall.item;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemEveriteNugget extends Item {
    public static final Item block = new ItemEveriteNugget();

    public ItemEveriteNugget() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("everite_nugget");
        this.setRegistryName("everite_nugget");
        this.setCreativeTab(TabCTab.tab);

    }
@SideOnly(Side.CLIENT)
    public boolean hasEffect(final ItemStack itemstack) {
    return true;
    }

}
