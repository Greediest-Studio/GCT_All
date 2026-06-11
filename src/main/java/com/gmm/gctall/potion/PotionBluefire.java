package com.gmm.gctall.potion;

import com.gmm.gctall.Tags;
import com.gmm.gctall.procedure.ProcedureBluefireOnPotionActiveTick;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public final class PotionBluefire {
    public static final Potion potion = new BluefireEffect();
    public static final PotionType potionType = new BluefireEffectType();
  private PotionBluefire() {
  }

    public static class BluefireEffectType extends PotionType {
        public BluefireEffectType() {
            super(new PotionEffect(potion, 3600));
            setRegistryName(new ResourceLocation(Tags.MOD_ID, "bluefire"));
        }
    }

    public static class BluefireEffect extends Potion {
        private final ResourceLocation potionIcon;

        public BluefireEffect() {
            super(true, 0x004CFF);
            setRegistryName(new ResourceLocation(Tags.MOD_ID, "bluefire"));
            setPotionName("effect.bluefire");
            this.potionIcon = new ResourceLocation(Tags.MOD_ID, "textures/mob_effect/bluefire.png");
        }

        @Override
        public boolean isInstant() {
            return false;
        }

        @Override
        public boolean shouldRenderInvText(PotionEffect effect) {
            return true;
        }

        @Override
        public boolean shouldRenderHUD(PotionEffect effect) {
            return true;
        }

        @Override
        public void performEffect(EntityLivingBase entity, int amplifier) {
            Map<String, Object> dependencies = new HashMap<>();
            dependencies.put("entity", entity);
            ProcedureBluefireOnPotionActiveTick.executeProcedure(dependencies);
        }

        @SideOnly(Side.CLIENT)
        @Override
        public void renderInventoryEffect(int x, int y, PotionEffect effect, Minecraft mc) {
            if (mc.currentScreen != null) {
                mc.getTextureManager().bindTexture(potionIcon);
                Gui.drawModalRectWithCustomSizedTexture(x + 6, y + 7, 0.0F, 0.0F, 18, 18, 18.0F, 18.0F);
            }
        }

        @SideOnly(Side.CLIENT)
        @Override
        public void renderHUDEffect(int x, int y, PotionEffect effect, Minecraft mc, float alpha) {
            mc.getTextureManager().bindTexture(potionIcon);
            Gui.drawModalRectWithCustomSizedTexture(x + 3, y + 3, 0.0F, 0.0F, 18, 18, 18.0F, 18.0F);
        }

        @Override
        public boolean isReady(int duration, int amplifier) {
            return true;
        }
    }
}
