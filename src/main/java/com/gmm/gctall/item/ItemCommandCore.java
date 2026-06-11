
package com.gmm.gctall.item;

import net.minecraft.client.util.ITooltipFlag;
import java.util.List;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTabWitheric;
import net.minecraft.item.Item;

public class ItemCommandCore extends Item {
    public static final Item block = new ItemCommandCore();

    public ItemCommandCore() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("command_core");
        this.setRegistryName("command_core");
        this.setCreativeTab(TabCTabWitheric.tab);

    }
public void addInformation(final ItemStack itemstack, final World world, final List<String> list, final ITooltipFlag flag) {
    super.addInformation(itemstack, world, (List)list, flag);
    list.add("\u592a\u68d2\u4e86\uff0c\u8fd9\u4e2a\u4e1c\u897f\u6709\u7740\u81f3\u9ad8\u65e0\u4e0a\u7684\u547d\u4ee4\u6743\u9650\uff01");
    list.add("\u7528\u4e8e\u5408\u6210\u547d\u4ee4\u65b9\u5757");
    }

}
