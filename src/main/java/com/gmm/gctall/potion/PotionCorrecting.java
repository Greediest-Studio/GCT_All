package com.gmm.gctall.potion;

import com.gmm.gctall.Tags;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;

@Tag
public class PotionCorrecting extends GctAllElement {
  public static final Potion potion = new PotionCustom();
  
  public PotionCorrecting(GctAllContent instance) {
    super(instance, 364);
  }
  
  public void initElements() {
    registerPotion(() -> potion);
  }
  
  public static class PotionCustom extends Potion {
    private final ResourceLocation potionIcon;
    
    public PotionCustom() {
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

