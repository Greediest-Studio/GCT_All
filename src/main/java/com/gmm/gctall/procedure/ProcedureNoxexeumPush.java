
package com.gmm.gctall.procedure;

import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import java.util.Map;
public final class ProcedureNoxexeumPush
{
    private ProcedureNoxexeumPush() {
    }
    
    public static void executeProcedure(final Map<String, Object> dependencies) {
        if (dependencies.get("entity") == null) {
            System.err.println("Failed to load dependency entity for procedure NoxexeumPush!");
            return;
        }
        final Entity entity = (Entity)dependencies.get("entity");
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


