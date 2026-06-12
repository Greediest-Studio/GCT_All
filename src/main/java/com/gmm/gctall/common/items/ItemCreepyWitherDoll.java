
package com.gmm.gctall.common.items;

import java.util.List;

import com.gmm.gctall.misc.GctAllCreativeTab;
import com.gmm.gctall.common.events.CreepyWitherDollClick;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;

public class ItemCreepyWitherDoll extends Item {
    public static final Item block = new ItemCreepyWitherDoll();

    public ItemCreepyWitherDoll() {
        this.setMaxDamage(0);
        this.maxStackSize = 1;
        this.setTranslationKey("creepy_wither_doll");
        this.setRegistryName("creepy_wither_doll");
        this.setCreativeTab(GctAllCreativeTab.TAB);

    }

    @Override
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
        super.addInformation(stack, world, tooltip, flag);
        tooltip.add("\u5176\u5b9e\u8fd8\u662f\u86ee\u53ef\u7231\u7684\u561b\u2026\u2026");
        tooltip.add("\u5728\u672b\u5730\u539f\u70b9\u53f3\u952e\u4f20\u9001\u81f3\u865a\u7a7a\u4e4b\u5730");
        tooltip.add("\u5728\u865a\u7a7a\u4e4b\u5730\u4efb\u610f\u5730\u70b9\u53f3\u952e\u4f20\u9001\u56de\u672b\u5730");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        CreepyWitherDollClick.run(player, world, (int) player.posX, (int) player.posY, (int) player.posZ);
        return new ActionResult<>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
    }
}
