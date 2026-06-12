
package com.gmm.gctall.common.events;

import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
public final class NoxexeumPush
{
    private NoxexeumPush() {
    }
    
    public static void run(Entity entity) {
        if (entity.getDisplayName().getUnformattedText().equals("bninz") || entity.getDisplayName().getUnformattedText().equals("\u9ed1\u6697\u4eba")) {
            if (entity instanceof EntityLivingBase) {
                ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 20, 1, false, false));
            }
        }
        else if (entity instanceof EntityLivingBase) {
            ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 100, 1, false, false));
        }
    }
}


