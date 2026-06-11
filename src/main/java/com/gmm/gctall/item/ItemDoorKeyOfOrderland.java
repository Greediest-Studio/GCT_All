
package com.gmm.gctall.item;

import java.util.Map;
import com.gmm.gctall.procedure.ProcedureDoorKeyOrderlandClick;
import java.util.HashMap;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.util.ITooltipFlag;
import java.util.List;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTabWitheric;
import net.minecraft.item.Item;

public class ItemDoorKeyOfOrderland extends Item {
    public static final Item block = new ItemDoorKeyOfOrderland();

    public ItemDoorKeyOfOrderland() {
        this.setMaxDamage(0);
        this.maxStackSize = 1;
        this.setTranslationKey("door_key_of_orderland");
        this.setRegistryName("door_key_of_orderland");
        this.setCreativeTab(TabCTabWitheric.tab);

    }
public void addInformation(final ItemStack itemstack, final World world, final List<String> list, final ITooltipFlag flag) {
    super.addInformation(itemstack, world, (List)list, flag);
    list.add("\u53f3\u952e\u751f\u6210\u4e00\u4e2a\u79e9\u5e8f\u4e4b\u5730\u4f20\u9001\u95e8\uff01");
    list.add("\u53ea\u6709\u51fb\u8d25\u4e86\u51cb\u7075\u98ce\u66b4\u7684\u4eba\u624d\u6709\u8d44\u683c\u8fdb\u5165\u79e9\u5e8f\u4e4b\u5730\u2026\u2026");
    }

    public EnumActionResult onItemUseFirst(final EntityPlayer entity, final World world, final BlockPos pos, final EnumFacing direction, final float hitX, final float hitY, final float hitZ, final EnumHand hand) {
    final EnumActionResult retval = super.onItemUseFirst(entity, world, pos, direction, hitX, hitY, hitZ, hand);
    final ItemStack itemstack = entity.getHeldItem(hand);
    final int x = pos.getX();
    final int y = pos.getY();
    final int z = pos.getZ();
    final Map<String, Object> $_dependencies = new HashMap<String, Object>();
    $_dependencies.put("entity", entity);
    $_dependencies.put("x", x);
    $_dependencies.put("y", y);
    $_dependencies.put("z", z);
    $_dependencies.put("world", world);
    ProcedureDoorKeyOrderlandClick.executeProcedure($_dependencies);
    return retval;
    }

}
