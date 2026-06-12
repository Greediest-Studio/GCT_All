
package com.gmm.gctall.common.items;

import java.util.List;

import com.gmm.gctall.misc.GctAllCreativeTab;
import com.gmm.gctall.common.events.CreepyWitherstormDollClick;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemCreepyWitherstormDoll extends Item {
    public static final Item block = new ItemCreepyWitherstormDoll();

    public ItemCreepyWitherstormDoll() {
        this.setMaxDamage(0);
        this.maxStackSize = 1;
        this.setTranslationKey("creepy_witherstorm_doll");
        this.setRegistryName("creepy_witherstorm_doll");
        this.setCreativeTab(GctAllCreativeTab.TAB);

    }

    @Override
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
        super.addInformation(stack, world, tooltip, flag);
        tooltip.add("\u4e5f\u633a\u53ef\u7231\u7684\u2026\u2026");
        tooltip.add("\u5b83\u5931\u53bb\u4e86\u4f20\u9001\u7684\u80fd\u529b\uff0c\u4e0d\u8fc7\u53ef\u4ee5\u53ec\u5524\u51cb\u7075\u98ce\u66b4\uff01");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        CreepyWitherstormDollClick.run(player, world, (int) player.posX, (int) player.posY, (int) player.posZ);
        return new ActionResult<>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
    }
}
