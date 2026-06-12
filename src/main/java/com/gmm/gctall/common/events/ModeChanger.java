
package com.gmm.gctall.common.events;

import com.gmm.gctall.common.util.ServerCommandHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
public final class ModeChanger
{
    private ModeChanger() {
    }
    
    public static void run(Entity entity, World world, int x, int y, int z) {
        if (entity instanceof EntityPlayer && ((EntityPlayer)entity).capabilities.isCreativeMode) {
            ServerCommandHelper.run(world, x, y, z, "gamemode 0 @p");
        }
        else {
            ServerCommandHelper.run(world, x, y, z, "gamemode 1 @p");
        }
    }
}


