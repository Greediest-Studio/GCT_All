package com.gmm.gctall.potion;

import com.gmm.gctall.Tags;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;

public final class PotionCorrecting {
  public static final Potion potion = new CorrectingEffect();
  private PotionCorrecting() {
  }

  public static class CorrectingEffect extends Potion {
    private final ResourceLocation potionIcon;

    public CorrectingEffect() {
      super(false, -1);
      setRegistryName(new ResourceLocation(Tags.MOD_ID, "correcting"));
      setPotionName("effect.correcting");
      this.potionIcon = new ResourceLocation("gct_all:textures/mob_effect/correcting.png");
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

