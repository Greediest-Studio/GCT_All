
package com.gmm.gctall.item;

import net.minecraft.client.util.ITooltipFlag;
import java.util.List;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemBluePrintEmpty extends Item {
    public static final Item block = new ItemBluePrintEmpty();

    public ItemBluePrintEmpty() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("blue_print_empty");
        this.setRegistryName("blue_print_empty");
        this.setCreativeTab(TabCTab.tab);

    }
public void addInformation(final ItemStack itemstack, final World world, final List<String> list, final ITooltipFlag flag) {
    super.addInformation(itemstack, world, (List)list, flag);
    list.add("\u7528\u4e8e\u5408\u6210\u6a21\u5757\u5316\u84dd\u56fe\uff01");
    }

}
