
package com.gmm.gctall.common.events;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
public final class LumixeiumTick
{
    private LumixeiumTick() {
    }
    
    public static void run(World world, int x, int y, int z) {
        if (world.getBlockState(new BlockPos(x + 1, y, z)).getLightValue() >= 12) {
            world.destroyBlock(new BlockPos(x + 1, y, z), false);
        }
        if (world.getBlockState(new BlockPos(x - 1, y, z)).getLightValue() >= 12) {
            world.destroyBlock(new BlockPos(x - 1, y, z), false);
        }
        if (world.getBlockState(new BlockPos(x, y, z + 1)).getLightValue() >= 12) {
            world.destroyBlock(new BlockPos(x, y, z + 1), false);
        }
        if (world.getBlockState(new BlockPos(x, y, z - 1)).getLightValue() >= 12) {
            world.destroyBlock(new BlockPos(x, y, z - 1), false);
        }
        if (world.getBlockState(new BlockPos(x, y - 1, z)).getLightValue() >= 12) {
            world.destroyBlock(new BlockPos(x, y - 1, z), false);
        }
    }
}


