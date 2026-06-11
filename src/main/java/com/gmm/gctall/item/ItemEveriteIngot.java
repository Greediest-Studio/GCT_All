
package com.gmm.gctall.item;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import net.minecraft.client.util.ITooltipFlag;
import java.util.List;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemEveriteIngot extends Item {
    public static final Item block = new ItemEveriteIngot();

    public ItemEveriteIngot() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("everite_ingot");
        this.setRegistryName("everite_ingot");
        this.setCreativeTab(TabCTab.tab);

    }
@SideOnly(Side.CLIENT)
    public boolean hasEffect(final ItemStack itemstack) {
    return true;
    }

    public void addInformation(final ItemStack itemstack, final World world, final List<String> list, final ITooltipFlag flag) {
    super.addInformation(itemstack, world, (List)list, flag);
    list.add("\u4e00\u5316\u4e07\u7269\uff0c\u4e07\u7269\u5316\u4e00");
    }

}
