
package com.gmm.gctall.common.events;

import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
public final class NaturaeumPush
{
    private NaturaeumPush() {
    }
    
    public static void run(Entity entity) {
        if (entity.getDisplayName().getUnformattedText().equals("bnatuz") || entity.getDisplayName().getUnformattedText().equals("\u81ea\u7136\u4eba")) {
            if (entity instanceof EntityLivingBase) {
                ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 20, 1, false, false));
            }
        }
        else if (entity instanceof EntityLivingBase) {
            ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 100, 2, false, false));
        }
    }
}


