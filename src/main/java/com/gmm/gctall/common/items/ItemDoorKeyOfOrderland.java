
package com.gmm.gctall.common.items;

import java.util.List;

import com.gmm.gctall.misc.GctAllCreativeTab;
import com.gmm.gctall.common.events.DoorKeyOrderlandClick;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemDoorKeyOfOrderland extends Item {
    public static final Item block = new ItemDoorKeyOfOrderland();

    public ItemDoorKeyOfOrderland() {
        this.setMaxDamage(0);
        this.maxStackSize = 1;
        this.setTranslationKey("door_key_of_orderland");
        this.setRegistryName("door_key_of_orderland");
        this.setCreativeTab(GctAllCreativeTab.TAB);

    }

    @Override
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
        super.addInformation(stack, world, tooltip, flag);
        tooltip.add("\u53f3\u952e\u751f\u6210\u4e00\u4e2a\u79e9\u5e8f\u4e4b\u5730\u4f20\u9001\u95e8\uff01");
        tooltip.add("\u53ea\u6709\u51fb\u8d25\u4e86\u51cb\u7075\u98ce\u66b4\u7684\u4eba\u624d\u6709\u8d44\u683c\u8fdb\u5165\u79e9\u5e8f\u4e4b\u5730\u2026\u2026");
    }

    @Override
    public EnumActionResult onItemUseFirst(EntityPlayer player, World world, BlockPos pos, EnumFacing direction,
            float hitX, float hitY, float hitZ, EnumHand hand) {
        DoorKeyOrderlandClick.run(player, world, pos.getX(), pos.getY(), pos.getZ());
        return EnumActionResult.SUCCESS;
    }
}
