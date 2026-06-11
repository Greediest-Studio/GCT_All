
package com.gmm.gctall.item;

import net.minecraft.client.util.ITooltipFlag;
import java.util.List;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemGeniteIngot extends Item {
    public static final Item block = new ItemGeniteIngot();

    public ItemGeniteIngot() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("genite_ingot");
        this.setRegistryName("genite_ingot");
        this.setCreativeTab(TabCTab.tab);

    }
public void addInformation(final ItemStack itemstack, final World world, final List<String> list, final ITooltipFlag flag) {
    super.addInformation(itemstack, world, (List)list, flag);
    list.add("\u57fa\u56e0\uff0c\u4e07\u7269\u4e4b\u6e90");
    }

}
