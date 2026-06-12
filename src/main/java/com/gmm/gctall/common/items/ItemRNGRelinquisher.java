
package com.gmm.gctall.common.items;

import java.util.List;

import com.gmm.gctall.misc.GctAllCreativeTab;
import com.gmm.gctall.common.events.RNGRelinquisherClick;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemRNGRelinquisher extends Item {
    public static final Item block = new ItemRNGRelinquisher();

    public ItemRNGRelinquisher() {
        this.setMaxDamage(0);
        this.maxStackSize = 1;
        this.setTranslationKey("rng_relinquisher");
        this.setRegistryName("rng_relinquisher");
        this.setCreativeTab(GctAllCreativeTab.TAB);

    }

    @Override
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
        super.addInformation(stack, world, tooltip, flag);
        tooltip.add("\u5728\u672b\u5730\u539f\u70b9\u53f3\u952e\u4f20\u9001\u81f3\u65e0\u540d\u4e4b\u5730");
        tooltip.add("\u5728\u65e0\u540d\u4e4b\u5730\u4efb\u610f\u5730\u70b9\u53f3\u952e\u4f20\u9001\u56de\u672b\u5730");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        RNGRelinquisherClick.run(player, world, (int) player.posX, (int) player.posY, (int) player.posZ);
        return new ActionResult<>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
    }
}
