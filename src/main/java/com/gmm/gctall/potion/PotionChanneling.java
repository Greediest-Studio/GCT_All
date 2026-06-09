package com.gmm.gctall.potion;

import java.util.HashMap;
import java.util.Map;
import com.gmm.gctall.Tags;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.procedure.ProcedureProChannelingTick;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Tag
public class PotionChanneling extends GctAllElement {
  public static final Potion potion = new PotionCustom();
  
  public static final PotionType potionType = new PotionTypeCustom();
  
  public PotionChanneling(GctAllContent instance) {
    super(instance, 117);
  }
  
  public void initElements() {
    registerPotion(() -> potion);
    registerPotionType(() -> potionType);
  }
  
  public static class PotionTypeCustom extends PotionType {
    public PotionTypeCustom() {
      super(new PotionEffect[] { new PotionEffect(PotionChanneling.potion, 3600) });
      setRegistryName(new ResourceLocation(Tags.MOD_ID, "channeling"));
    }
  }
  
  public static class PotionCustom extends Potion {
    private final ResourceLocation potionIcon;
    
    public PotionCustom() {
      super(true, -13434625);
      setRegistryName(new ResourceLocation(Tags.MOD_ID, "channeling"));
      setPotionName("effect.channeling");
      this.potionIcon = new ResourceLocation("gct_all:textures/mob_effect/channeling.png");
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
    
    public void performEffect(EntityLivingBase entity, int amplifier) {
      World world = entity.world;
      int x = (int)entity.posX;
      int y = (int)entity.posY;
      int z = (int)entity.posZ;
      Map<String, Object> $_dependencies = new HashMap<>();
      $_dependencies.put("x", Integer.valueOf(x));
      $_dependencies.put("y", Integer.valueOf(y));
      $_dependencies.put("z", Integer.valueOf(z));
      $_dependencies.put("world", world);
      ProcedureProChannelingTick.executeProcedure($_dependencies);
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

