
package com.gmm.gctall.common.events;

import com.gmm.gctall.common.blocks.BlockSenterianLament;
import com.gmm.gctall.common.util.ServerCommandHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
public final class SenterianSummonerSummon
{
    private SenterianSummonerSummon() {
    }
    
    public static void run(World world, int x, int y, int z) {
        if (world.getBlockState(new BlockPos(x + 12, y + 0, z + 0)).getBlock() == BlockSenterianLament.block.getDefaultState().getBlock() && world.getBlockState(new BlockPos(x + 0, y + 0, z + 12)).getBlock() == BlockSenterianLament.block.getDefaultState().getBlock() && world.getBlockState(new BlockPos(x - 12, y + 0, z + 0)).getBlock() == BlockSenterianLament.block.getDefaultState().getBlock() && world.getBlockState(new BlockPos(x + 0, y + 0, z - 12)).getBlock() == BlockSenterianLament.block.getDefaultState().getBlock() && world.getBlockState(new BlockPos(x + 10, y + 0, z + 10)).getBlock() == BlockSenterianLament.block.getDefaultState().getBlock() && world.getBlockState(new BlockPos(x - 10, y + 0, z + 10)).getBlock() == BlockSenterianLament.block.getDefaultState().getBlock() && world.getBlockState(new BlockPos(x - 10, y + 0, z - 10)).getBlock() == BlockSenterianLament.block.getDefaultState().getBlock() && world.getBlockState(new BlockPos(x + 10, y + 0, z - 10)).getBlock() == BlockSenterianLament.block.getDefaultState().getBlock()) {
            ServerCommandHelper.run(world, x, y, z, "fill ~5 ~-1 ~5 ~-5 ~17 ~-5 air");
            ServerCommandHelper.run(world, x, y, z, "summon journey:sentryheart ~ ~ ~");
            ServerCommandHelper.run(world, x, y, z, "tellraw @a[r=32] [\"\",{\"text\":\"\u54e8\u5175\u4e4b\u5fc3 \u5df2\u82cf\u9192\uff01\"}] ");
        }
    }
}


