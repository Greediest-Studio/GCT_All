
package com.gmm.gctall.item;

import net.minecraft.client.util.ITooltipFlag;
import java.util.List;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemBluePrintForge extends Item {
    public static final Item block = new ItemBluePrintForge();

    public ItemBluePrintForge() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("blue_print_forge");
        this.setRegistryName("blue_print_forge");
        this.setCreativeTab(TabCTab.tab);

    }
public void addInformation(final ItemStack itemstack, final World world, final List<String> list, final ITooltipFlag flag) {
    super.addInformation(itemstack, world, (List)list, flag);
    list.add("\u7528\u4e8e\u5408\u6210\u91d1\u5c5e\u7194\u7089\u7684\u84dd\u56fe");
    }

}
