package com.gmm.gctall.item;

import com.gmm.gctall.common.GctAllCreativeTab;

import com.gmm.gctall.world.dimension.WorldEverheaven;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

public class ItemEverheaven extends Item {
  @ObjectHolder("gct_all:everheaven")
  public static final Item block = null;
  
  public ItemEverheaven() {
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
      WorldEverheaven.portal.portalSpawn(world, pos); 
    itemstack.damageItem(1, (EntityLivingBase)entity);
    return EnumActionResult.SUCCESS;
  }
}

