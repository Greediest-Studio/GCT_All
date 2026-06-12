
package com.gmm.gctall.common.events;

import com.gmm.gctall.common.util.ServerCommandHelper;
import net.minecraft.entity.player.EntityPlayerMP;
import java.util.Random;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

public final class CommandDismantlerClick
{
    private CommandDismantlerClick() {
    }
    
    public static void run(Entity entity, ItemStack itemstack, World world, int x, int y, int z) {
        if (world.getBlockState(new BlockPos(x, y, z)).getBlock() == Blocks.COMMAND_BLOCK.getDefaultState().getBlock()) {
            if (entity instanceof EntityLivingBase) {
                ((EntityLivingBase)entity).swingArm(EnumHand.MAIN_HAND);
            }
            world.destroyBlock(new BlockPos(x, y, z), false);
            if (!world.isRemote) {
                final EntityItem entityToSpawn = new EntityItem(world, (double)x, (double)y, (double)z, new ItemStack(Blocks.COMMAND_BLOCK, 1));
                entityToSpawn.setPickupDelay(10);
                world.spawnEntity((Entity)entityToSpawn);
            }
            final ItemStack _ist = itemstack;
            if (_ist.attemptDamageItem(1, new Random(), (EntityPlayerMP)null)) {
                _ist.shrink(1);
                _ist.setItemDamage(0);
            }
        }
        else if (world.getBlockState(new BlockPos(x, y, z)).getBlock() == Blocks.REPEATING_COMMAND_BLOCK.getDefaultState().getBlock()) {
            if (entity instanceof EntityLivingBase) {
                ((EntityLivingBase)entity).swingArm(EnumHand.MAIN_HAND);
            }
            world.destroyBlock(new BlockPos(x, y, z), false);
            if (!world.isRemote) {
                final EntityItem entityToSpawn = new EntityItem(world, (double)x, (double)y, (double)z, new ItemStack(Blocks.REPEATING_COMMAND_BLOCK, 1));
                entityToSpawn.setPickupDelay(10);
                world.spawnEntity((Entity)entityToSpawn);
            }
            final ItemStack _ist = itemstack;
            if (_ist.attemptDamageItem(1, new Random(), (EntityPlayerMP)null)) {
                _ist.shrink(1);
                _ist.setItemDamage(0);
            }
        }
        else if (world.getBlockState(new BlockPos(x, y, z)).getBlock() == Blocks.CHAIN_COMMAND_BLOCK.getDefaultState().getBlock()) {
            if (entity instanceof EntityLivingBase) {
                ((EntityLivingBase)entity).swingArm(EnumHand.MAIN_HAND);
            }
            world.destroyBlock(new BlockPos(x, y, z), false);
            if (!world.isRemote) {
                final EntityItem entityToSpawn = new EntityItem(world, (double)x, (double)y, (double)z, new ItemStack(Blocks.CHAIN_COMMAND_BLOCK, 1));
                entityToSpawn.setPickupDelay(10);
                world.spawnEntity((Entity)entityToSpawn);
            }
            final ItemStack _ist = itemstack;
            if (_ist.attemptDamageItem(1, new Random(), (EntityPlayerMP)null)) {
                _ist.shrink(1);
                _ist.setItemDamage(0);
            }
        }
        else if (world.getBlockState(new BlockPos(x, y, z)).getBlock() == Blocks.STRUCTURE_BLOCK.getDefaultState().getBlock()) {
            if (entity instanceof EntityLivingBase) {
                ((EntityLivingBase)entity).swingArm(EnumHand.MAIN_HAND);
            }
            world.destroyBlock(new BlockPos(x, y, z), false);
            if (!world.isRemote) {
                final EntityItem entityToSpawn = new EntityItem(world, (double)x, (double)y, (double)z, new ItemStack(Blocks.STRUCTURE_BLOCK, 1));
                entityToSpawn.setPickupDelay(10);
                world.spawnEntity((Entity)entityToSpawn);
            }
            final ItemStack _ist = itemstack;
            if (_ist.attemptDamageItem(1, new Random(), (EntityPlayerMP)null)) {
                _ist.shrink(1);
                _ist.setItemDamage(0);
            }
        }
        else {
            ServerCommandHelper.run(world, x, y, z, "say @p \uff0c\u8be5\u65b9\u5757\u65e0\u6cd5\u62c6\u9664\uff01");
        }
    }
}


