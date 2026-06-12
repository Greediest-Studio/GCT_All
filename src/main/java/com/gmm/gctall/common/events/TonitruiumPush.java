
package com.gmm.gctall.common.events;

import com.gmm.gctall.common.util.ServerCommandHelper;
import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
public final class TonitruiumPush
{
    private TonitruiumPush() {
    }
    
    public static void run(Entity entity, World world) {
        if (entity.getDisplayName().getUnformattedText().equals("bthdz") || entity.getDisplayName().getUnformattedText().equals("\u96f7\u7535\u4eba")) {
            if (entity instanceof EntityLivingBase) {
                ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 20, 1, false, false));
            }
        } else {
            ServerCommandHelper.run(world, (int) entity.posX, (int) entity.posY, (int) entity.posZ, "effect @p gct_all:channeling 6 0");
        }
    }
}


