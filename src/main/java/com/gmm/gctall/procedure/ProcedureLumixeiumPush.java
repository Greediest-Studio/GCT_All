
package com.gmm.gctall.procedure;

import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import java.util.Map;
public final class ProcedureLumixeiumPush
{
    private ProcedureLumixeiumPush() {
    }
    
    public static void executeProcedure(final Map<String, Object> dependencies) {
        if (dependencies.get("entity") == null) {
            System.err.println("Failed to load dependency entity for procedure LumixeiumPush!");
            return;
        }
        final Entity entity = (Entity)dependencies.get("entity");
        if (entity.getDisplayName().getUnformattedText().equals("bligtz") || entity.getDisplayName().getUnformattedText().equals("\u5149\u660e\u4eba")) {
            if (entity instanceof EntityLivingBase) {
                ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 20, 1, false, false));
            }
        }
        else if (entity instanceof EntityLivingBase) {
            ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(MobEffects.GLOWING, 100, 1, false, false));
        }
    }
}


