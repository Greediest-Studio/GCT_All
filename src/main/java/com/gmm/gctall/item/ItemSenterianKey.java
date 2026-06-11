
package com.gmm.gctall.item;

import net.minecraft.client.util.ITooltipFlag;
import java.util.List;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemSenterianKey extends Item {
    public static final Item block = new ItemSenterianKey();

    public ItemSenterianKey() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("senterian_key");
        this.setRegistryName("senterian_key");
        this.setCreativeTab(TabCTab.tab);

    }
public void addInformation(final ItemStack itemstack, final World world, final List<String> list, final ITooltipFlag flag) {
    super.addInformation(itemstack, world, (List)list, flag);
    list.add("\u7528\u4e8e\u6253\u5f00\u9ed1\u5ca9\u4e4b\u9501");
    }

}
