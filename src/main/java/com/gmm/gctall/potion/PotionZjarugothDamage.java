package com.gmm.gctall.potion;

import java.util.HashMap;
import java.util.Map;
import com.gmm.gctall.Tags;
import com.gmm.gctall.procedure.ProcedureZjarugothDamagePotionStartedapplied;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public final class PotionZjarugothDamage {
  public static final Potion potion = new ZjarugothDamageEffect();
  private PotionZjarugothDamage() {
  }

  public static class ZjarugothDamageEffect extends Potion {
    private final ResourceLocation potionIcon;

    public ZjarugothDamageEffect() {
      super(true, -1);
      setRegistryName(new ResourceLocation(Tags.MOD_ID, "zjarugoth_damage"));
      setPotionName("effect.zjarugoth_damage");
      this.potionIcon = new ResourceLocation("gct_all:textures/mob_effect/zjarugoth_damage.png");
    }

    public boolean isInstant() {
      return true;
    }

    public boolean shouldRenderInvText(PotionEffect effect) {
      return false;
    }

    public boolean shouldRenderHUD(PotionEffect effect) {
      return false;
    }

    public void affectEntity(Entity source, Entity indirectSource, EntityLivingBase entity, int amplifier, double health) {
      World world = entity.world;
      int x = (int)entity.posX;
      int y = (int)entity.posY;
      int z = (int)entity.posZ;
      Map<String, Object> $_dependencies = new HashMap<>();
      $_dependencies.put("entity", entity);
      ProcedureZjarugothDamagePotionStartedapplied.executeProcedure($_dependencies);
    }

    public boolean isReady(int duration, int amplifier) {
      return true;
    }
  }
}

