
package com.gmm.gctall.item;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import net.minecraft.client.util.ITooltipFlag;
import java.util.List;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTabWitheric;
import net.minecraft.item.Item;

public class ItemOrderCrystal extends Item {
    public static final Item block = new ItemOrderCrystal();

    public ItemOrderCrystal() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("order_crystal");
        this.setRegistryName("order_crystal");
        this.setCreativeTab(TabCTabWitheric.tab);

    }
@SideOnly(Side.CLIENT)
    public boolean hasEffect(final ItemStack itemstack) {
    return true;
    }

    public void addInformation(final ItemStack itemstack, final World world, final List<String> list, final ITooltipFlag flag) {
    super.addInformation(itemstack, world, (List)list, flag);
    list.add("\u79e9\u5e8f\uff0c\u8574\u542b\u4e8e\u8fd9\u4e00\u65b9\u5c0f\u5c0f\u6c34\u6676\u4e2d");
    }

}
