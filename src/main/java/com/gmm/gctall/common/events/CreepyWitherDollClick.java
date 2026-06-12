
package com.gmm.gctall.common.events;

import com.gmm.gctall.common.util.ServerCommandHelper;
import com.gmm.gctall.common.world.dimension.WorldTheVoid;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
public final class CreepyWitherDollClick
{
    private CreepyWitherDollClick() {
    }
    
    public static void run(Entity entity, World world, int x, int y, int z) {
        if (entity.dimension == 1 && x == 0 && z == 0) {
            if (!entity.world.isRemote && !entity.isRiding() && !entity.isBeingRidden() && entity instanceof EntityPlayerMP) {
                TeleporterDirect.transferToSpawn((EntityPlayerMP) entity, WorldTheVoid.DIMID);
            }
        }
        else if (entity.dimension == WorldTheVoid.DIMID) {
            if (!entity.world.isRemote && !entity.isRiding() && !entity.isBeingRidden() && entity instanceof EntityPlayerMP) {
                TeleporterDirect.transferToSpawn((EntityPlayerMP) entity, 1);
            }
        }
        else if (entity.dimension != 1 && entity.dimension != WorldTheVoid.DIMID) {
            ServerCommandHelper.run(world, x, y, z, "tellraw @p[r=32] [\"\",{\"text\":\"\u53ef\u6015\u7684\u51cb\u7075\u73a9\u5076\uff1a\u6211\u8c8c\u4f3c\u4e0d\u80fd\u5728\u8fd9\u4e2a\u7ef4\u5ea6\u65bd\u5c55\u80fd\u529b\u2026\u2026\"}] ");
        }
        else {
            ServerCommandHelper.run(world, x, y, z, "tellraw @p[r=32] [\"\",{\"text\":\"\u53ef\u6015\u7684\u51cb\u7075\u73a9\u5076\uff1a \u53ea\u6709\u6765\u5230\u4e86\u672b\u8def\u4e4b\u5730\u7684\u539f\u70b9\uff0c\u6211\u624d\u80fd\u65bd\u5c55\u80fd\u529b\uff01\"}] ");
        }
    }
}


