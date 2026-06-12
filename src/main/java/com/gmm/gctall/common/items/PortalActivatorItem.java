package com.gmm.gctall.common.items;

import java.util.function.BiConsumer;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PortalActivatorItem extends Item {
    private final BiConsumer<World, BlockPos> portalSpawner;
    private final Block portalBlock;

    public PortalActivatorItem(String name, CreativeTabs tab, Block portalBlock, BiConsumer<World, BlockPos> portalSpawner) {
        this.portalBlock = portalBlock;
        this.portalSpawner = portalSpawner;
        setMaxStackSize(1);
        setMaxDamage(64);
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(tab);
    }

    @Override
    public EnumActionResult onItemUseFirst(EntityPlayer player, World world, BlockPos pos, EnumFacing facing,
            float hitX, float hitY, float hitZ, EnumHand hand) {
        return EnumActionResult.PASS;
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand,
            EnumFacing facing, float hitX, float hitY, float hitZ) {
        return usePortalActivator(player, world, pos, hand, facing);
    }

    private EnumActionResult usePortalActivator(EntityPlayer player, World world, BlockPos pos, EnumHand hand,
            EnumFacing facing) {
        ItemStack stack = player.getHeldItem(hand);
        for (BlockPos targetPos : new BlockPos[] { pos.offset(facing), pos }) {
            if (!player.canPlayerEdit(targetPos, facing, stack)) {
                continue;
            }
            if (!world.isAirBlock(targetPos)) {
                continue;
            }
            if (world.isRemote) {
                return EnumActionResult.SUCCESS;
            }
            portalSpawner.accept(world, targetPos);
            if (hasPortalNear(world, targetPos)) {
                stack.damageItem(1, (EntityLivingBase) player);
                return EnumActionResult.SUCCESS;
            }
        }
        return EnumActionResult.FAIL;
    }

    private boolean hasPortalNear(World world, BlockPos center) {
        for (BlockPos checkPos : BlockPos.getAllInBox(center.add(-3, -3, -3), center.add(3, 5, 3))) {
            if (world.getBlockState(checkPos).getBlock() == portalBlock) {
                return true;
            }
        }
        return false;
    }
}
