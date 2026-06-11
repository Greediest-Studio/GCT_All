
package com.gmm.gctall.item;

import net.minecraft.client.util.ITooltipFlag;
import java.util.List;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemDoorKeyEmpty extends Item {
    public static final Item block = new ItemDoorKeyEmpty();

    public ItemDoorKeyEmpty() {
        this.setMaxDamage(0);
        this.maxStackSize = 1;
        this.setTranslationKey("door_key_empty");
        this.setRegistryName("door_key_empty");
        this.setCreativeTab(TabCTab.tab);

    }
public void addInformation(final ItemStack itemstack, final World world, final List<String> list, final ITooltipFlag flag) {
    super.addInformation(itemstack, world, (List)list, flag);
    list.add("\u53ef\u4ee5\u5728\u6df1\u6e0a\u4eea\u5f0f\u4e0a\u7ed1\u5b9a\u5bf9\u5e94\u95e8\u94a5\u5319\uff01");
    }

}
