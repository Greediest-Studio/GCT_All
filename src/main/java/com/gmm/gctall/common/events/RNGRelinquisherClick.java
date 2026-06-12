
package com.gmm.gctall.common.events;

import com.gmm.gctall.common.util.ServerCommandHelper;
import com.gmm.gctall.common.world.dimension.WorldTheNowhere;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
public final class RNGRelinquisherClick
{
    private RNGRelinquisherClick() {
    }
    
    public static void run(Entity entity, World world, int x, int y, int z) {
        if (entity.dimension == 1 && x == 0 && z == 0) {
            if (!entity.world.isRemote && !entity.isRiding() && !entity.isBeingRidden() && entity instanceof EntityPlayerMP) {
                TeleporterDirect.transferToSpawn((EntityPlayerMP) entity, WorldTheNowhere.DIMID);
            }
        }
        else if (entity.dimension == WorldTheNowhere.DIMID) {
            if (!entity.world.isRemote && !entity.isRiding() && !entity.isBeingRidden() && entity instanceof EntityPlayerMP) {
                TeleporterDirect.transferToSpawn((EntityPlayerMP) entity, 1);
            }
        }
        else if (entity.dimension != 1 && entity.dimension != WorldTheNowhere.DIMID) {
            ServerCommandHelper.run(world, x, y, z, "tellraw @p[r=32] [\"\",{\"text\":\"\u8c8c\u4f3c\u4e0d\u80fd\u5728\u8fd9\u4e2a\u7ef4\u5ea6\u4f7f\u7528\u8fd9\u4e2a\u7269\u54c1\u2026\u2026\"}] ");
        }
        else {
            ServerCommandHelper.run(world, x, y, z, "tellraw @p[r=32] [\"\",{\"text\":\"\u6216\u8bb8\u6211\u9700\u8981\u62b5\u8fbe\u672b\u8def\u4e4b\u5730\u7684\u539f\u70b9\uff1f\"}] ");
        }
    }
}


