
package com.gmm.gctores.item;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityLivingBase;
import com.gmm.gctores.world.WorldDIM102;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ItemDIM102 extends Item
{
    @GameRegistry.ObjectHolder("gct_ores:orderland")
    public static final Item block;
    
    public ItemDIM102() {
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
            WorldDIM102.portal.portalSpawn(world, pos);
        }
        itemstack.damageItem(1, (EntityLivingBase)entity);
        return EnumActionResult.SUCCESS;
    }
    
    static {
        block = null;
    }
}
