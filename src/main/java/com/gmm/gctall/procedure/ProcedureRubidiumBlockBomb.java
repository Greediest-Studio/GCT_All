
package com.gmm.gctall.procedure;

import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import java.util.Map;
public final class ProcedureRubidiumBlockBomb
{
    private ProcedureRubidiumBlockBomb() {
    }
    
    public static void executeProcedure(final Map<String, Object> dependencies) {
        if (dependencies.get("x") == null) {
            System.err.println("Failed to load dependency x for procedure RubidiumBlockBomb!");
            return;
        }
        if (dependencies.get("y") == null) {
            System.err.println("Failed to load dependency y for procedure RubidiumBlockBomb!");
            return;
        }
        if (dependencies.get("z") == null) {
            System.err.println("Failed to load dependency z for procedure RubidiumBlockBomb!");
            return;
        }
        if (dependencies.get("world") == null) {
            System.err.println("Failed to load dependency world for procedure RubidiumBlockBomb!");
            return;
        }
        final int x = (int)dependencies.get("x");
        final int y = (int)dependencies.get("y");
        final int z = (int)dependencies.get("z");
        final World world = (World)dependencies.get("world");
        if (world.getBlockState(new BlockPos(x, y, z + 1)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock() || world.getBlockState(new BlockPos(x, y, z - 1)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock() || world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock() || world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock() || world.getBlockState(new BlockPos(x + 1, y, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock() || world.getBlockState(new BlockPos(x - 1, y, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock() || world.getBlockState(new BlockPos(x, y, z + 1)).getBlock() == Blocks.WATER.getDefaultState().getBlock() || world.getBlockState(new BlockPos(x, y, z - 1)).getBlock() == Blocks.WATER.getDefaultState().getBlock() || world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock() || world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock() || world.getBlockState(new BlockPos(x + 1, y, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock() || world.getBlockState(new BlockPos(x - 1, y, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock() || world.getBlockState(new BlockPos(x, y, z + 1)).getBlock() == Blocks.FIRE.getDefaultState().getBlock() || world.getBlockState(new BlockPos(x, y, z - 1)).getBlock() == Blocks.FIRE.getDefaultState().getBlock() || world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Blocks.FIRE.getDefaultState().getBlock() || world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FIRE.getDefaultState().getBlock() || world.getBlockState(new BlockPos(x + 1, y, z)).getBlock() == Blocks.FIRE.getDefaultState().getBlock() || world.getBlockState(new BlockPos(x - 1, y, z)).getBlock() == Blocks.FIRE.getDefaultState().getBlock()) {
            world.setBlockState(new BlockPos(x, y, z), Blocks.AIR.getDefaultState(), 3);
            if (!world.isRemote) {
                world.createExplosion((Entity)null, (double)x, (double)y, (double)z, 12.0f, true);
            }
        }
        else if (Math.random() < 0.01) {
            world.setBlockState(new BlockPos(x, y + 1, z), Blocks.FIRE.getDefaultState(), 3);
        }
    }
}


