
package com.gmm.gctall.common.items;

import java.util.List;

import com.gmm.gctall.misc.GctAllCreativeTab;
import com.gmm.gctall.common.events.ModeChanger;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemGreedycraftModChanger extends Item {
    public static final Item block = new ItemGreedycraftModChanger();

    public ItemGreedycraftModChanger() {
        this.setMaxDamage(0);
        this.maxStackSize = 1;
        this.setTranslationKey("greedycraft_mod_changer");
        this.setRegistryName("greedycraft_mod_changer");
        this.setCreativeTab(GctAllCreativeTab.TAB);

    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

    @Override
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
        super.addInformation(stack, world, tooltip, flag);
        tooltip.add("\u53f3\u952e\u5728\u751f\u5b58\u548c\u521b\u9020\u4e4b\u95f4\u8fdb\u884c\u5207\u6362");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ModeChanger.run(player, world, (int) player.posX, (int) player.posY, (int) player.posZ);
        return new ActionResult<>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
    }
}
