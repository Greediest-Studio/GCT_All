package com.gmm.gctall.potion;

import com.gmm.gctall.Tags;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;

public final class PotionOverrestrain {
  public static final Potion potion = new OverrestrainEffect();
  private PotionOverrestrain() {
  }

  public static class OverrestrainEffect extends Potion {
    private final ResourceLocation potionIcon;

    public OverrestrainEffect() {
      super(false, -3407668);
      setBeneficial();
      setRegistryName(new ResourceLocation(Tags.MOD_ID, "overrestrain"));
      setPotionName("effect.overrestrain");
      this.potionIcon = new ResourceLocation("gct_all:textures/mob_effect/overrestrain.png");
    }

    public boolean isInstant() {
      return false;
    }

    public boolean shouldRenderInvText(PotionEffect effect) {
      return false;
    }

    public boolean shouldRenderHUD(PotionEffect effect) {
      return false;
    }

    public boolean isReady(int duration, int amplifier) {
      return true;
    }
  }
}

