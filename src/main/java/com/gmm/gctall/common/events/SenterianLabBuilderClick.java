
package com.gmm.gctall.common.events;

import com.gmm.gctall.common.util.ServerCommandHelper;
import com.gmm.gctall.common.world.structure.StructureGenerationHelper;
import com.gmm.gctall.common.world.structure.GctAllStructureTemplates;

import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
public final class SenterianLabBuilderClick
{
    private SenterianLabBuilderClick() {
    }
    
    public static void run(World world, int x, int y, int z) {
        if (world.provider.getDimension() == 829 && y == 21) {
            world.setBlockState(new BlockPos(x, y, z), Blocks.AIR.getDefaultState(), 3);
            ServerCommandHelper.run(world, x, y, z, "tellraw @p[r=32] [\"\",{\"text\":\"\u9ed1\u5ca9\u5b9e\u9a8c\u5ba4\u5df2\u7ecf\u751f\u6210\uff01\u53ef\u80fd\u4f1a\u9020\u6210\u4e00\u5b9a\u5361\u987f\uff0c\u8bf7\u77e5\u6089\"}] ");
            if (!world.isRemote) {
                StructureGenerationHelper.placeTemplate(world, GctAllStructureTemplates.SENTERIAN_LAB, new BlockPos(x, y, z), Rotation.NONE, Mirror.NONE);
            }
        }
        else {
            ServerCommandHelper.run(world, x, y, z, "tellraw @p[r=32] [\"\",{\"text\":\"\u7ef4\u5ea6\u6216\u9ad8\u5ea6\u4e0d\u6b63\u786e\uff01\"}] ");
        }
    }
}



