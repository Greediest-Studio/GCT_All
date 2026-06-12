
package com.gmm.gctall.common.events;

import com.gmm.gctall.common.util.ServerCommandHelper;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
public final class WrenchBreak
{
    private WrenchBreak() {
    }
    
    public static void run(Entity entity, World world, int x, int y, int z) {
        ServerCommandHelper.run(world, x, y, z, "fill ~ ~ ~ ~ ~ ~ gct_all:senterian_lament 0 replace journey:lament 0");
        if (entity instanceof EntityLivingBase) {
            ((EntityLivingBase)entity).swingArm(EnumHand.MAIN_HAND);
        }
    }
}


