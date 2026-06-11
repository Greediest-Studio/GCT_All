
package com.gmm.gctall.item;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityLivingBase;
import com.gmm.gctall.world.WorldDIM100;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemDIM100 extends Item
{
    public static final Item block = new ItemDIM100().setTranslationKey("the_void").setRegistryName("the_void");
    
    public ItemDIM100() {
        this.maxStackSize = 1;
        this.setMaxDamage(64);
        this.setCreativeTab(CreativeTabs.TOOLS);
    }
    
    public EnumActionResult onItemUse(final EntityPlayer entity, final World world, BlockPos pos, final EnumHand hand, final EnumFacing facing, final float hitX, final float hitY, final float hitZ) {
        pos = pos.offset(facing);
        final ItemStack itemstack = entity.getHeldItem(hand);
        if (!entity.canPlayerEdit(pos, facing, itemstack)) {
            return EnumActionResult.FAIL;
        }
        if (world.isAirBlock(pos)) {
            WorldDIM100.portal.portalSpawn(world, pos);
        }
        itemstack.damageItem(1, (EntityLivingBase)entity);
        return EnumActionResult.SUCCESS;
    }
}

