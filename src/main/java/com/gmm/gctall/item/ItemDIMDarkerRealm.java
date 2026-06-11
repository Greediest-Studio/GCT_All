package com.gmm.gctall.item;

import com.gmm.gctall.common.GctAllCreativeTab;

import com.gmm.gctall.world.dimension.WorldDIMDarkerRealm;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemDIMDarkerRealm extends Item {
  public static final Item block = new ItemDIMDarkerRealm().setTranslationKey("dimdarkerrealm").setRegistryName("dimdarkerrealm");

  public ItemDIMDarkerRealm() {
    this.maxStackSize = 1;
    setMaxDamage(64);
    setCreativeTab(GctAllCreativeTab.TAB);
  }

  public EnumActionResult onItemUse(EntityPlayer entity, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
    pos = pos.offset(facing);
    ItemStack itemstack = entity.getHeldItem(hand);
    if (!entity.canPlayerEdit(pos, facing, itemstack))
      return EnumActionResult.FAIL;
    if (world.isAirBlock(pos))
      WorldDIMDarkerRealm.portal.portalSpawn(world, pos);
    itemstack.damageItem(1, (EntityLivingBase)entity);
    return EnumActionResult.SUCCESS;
  }
}


