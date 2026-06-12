
package com.gmm.gctall.common.events;

import com.gmm.gctall.common.blocks.BlockReditriteCobblestone;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.common.blocks.BlockReditriteBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
public final class ReditriteBlockDestroy
{
    private ReditriteBlockDestroy() {
    }
    
    public static void run(Entity entity, World world, int x, int y, int z) {
        if (Math.random() < 0.25) {
            if (!(entity instanceof EntityPlayer) || !((EntityPlayer)entity).capabilities.isCreativeMode) {
                if (!world.isRemote) {
                    final EntityItem entityToSpawn = new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, new ItemStack(BlockReditriteBlock.block, 1));
                    entityToSpawn.setPickupDelay(10);
                    world.spawnEntity((Entity)entityToSpawn);
                }
            }
        }
        else {
            world.setBlockState(new BlockPos(x, y, z), BlockReditriteCobblestone.block.getDefaultState(), 3);
        }
    }
}


