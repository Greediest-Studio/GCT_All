
package com.gmm.gctores.procedure;

import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import java.util.Map;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class ProcedureNaturaeumPush extends ElementsGctOresMod.ModElement
{
    public ProcedureNaturaeumPush(final ElementsGctOresMod instance) {
        super(instance, 317);
    }
    
    public static void executeProcedure(final Map<String, Object> dependencies) {
        if (dependencies.get("entity") == null) {
            System.err.println("Failed to load dependency entity for procedure NaturaeumPush!");
            return;
        }
        final Entity entity = (Entity)dependencies.get("entity");
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
