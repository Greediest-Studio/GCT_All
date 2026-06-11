package com.gmm.gctall.potion;

import com.gmm.gctall.Tags;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public final class PotionBlueScreen {
  public static final Potion potion = new BlueScreenEffect();

  public static final PotionType potionType = new BlueScreenEffectType();
  private PotionBlueScreen() {
  }

  public static class BlueScreenEffectType extends PotionType {
    public BlueScreenEffectType() {
      super(new PotionEffect[] { new PotionEffect(PotionBlueScreen.potion, 3600) });
      setRegistryName(new ResourceLocation(Tags.MOD_ID, "blue_screen"));
    }
  }

  public static class BlueScreenEffect extends Potion {
    private final ResourceLocation potionIcon;

    public BlueScreenEffect() {
      super(false, -16711681);
      setBeneficial();
      setRegistryName(new ResourceLocation(Tags.MOD_ID, "blue_screen"));
      setPotionName("effect.blue_screen");
      this.potionIcon = new ResourceLocation("gct_all:textures/mob_effect/blue_screen.png");
    }

    public boolean isInstant() {
      return false;
    }

    public boolean shouldRenderInvText(PotionEffect effect) {
      return true;
    }

    public boolean shouldRenderHUD(PotionEffect effect) {
      return true;
    }

    @SideOnly(Side.CLIENT)
    public void renderInventoryEffect(int x, int y, PotionEffect effect, Minecraft mc) {
      if (mc.currentScreen != null) {
        mc.getTextureManager().bindTexture(this.potionIcon);
        Gui.drawModalRectWithCustomSizedTexture(x + 6, y + 7, 0.0F, 0.0F, 18, 18, 18.0F, 18.0F);
      }
    }

    @SideOnly(Side.CLIENT)
    public void renderHUDEffect(int x, int y, PotionEffect effect, Minecraft mc, float alpha) {
      mc.getTextureManager().bindTexture(this.potionIcon);
      Gui.drawModalRectWithCustomSizedTexture(x + 3, y + 3, 0.0F, 0.0F, 18, 18, 18.0F, 18.0F);
    }

    public boolean isReady(int duration, int amplifier) {
      return true;
    }
  }
}

