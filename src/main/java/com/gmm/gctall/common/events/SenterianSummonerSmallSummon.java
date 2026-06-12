
package com.gmm.gctall.common.events;

import com.gmm.gctall.common.util.ServerCommandHelper;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
public final class SenterianSummonerSmallSummon
{
    private SenterianSummonerSmallSummon() {
    }
    
    public static void run(World world, int x, int y, int z) {
        world.setBlockState(new BlockPos(x, y, z), Blocks.AIR.getDefaultState(), 3);
        ServerCommandHelper.run(world, x, y, z, "summon journey:guardianofdestruction ~ ~ ~");
    }
}


