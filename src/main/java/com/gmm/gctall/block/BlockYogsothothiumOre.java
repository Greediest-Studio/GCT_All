package com.gmm.gctall.block;

import com.gmm.gctall.common.GctAllCreativeTab;

import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@Tag
public class BlockYogsothothiumOre extends GctAllElement {
  @ObjectHolder("gct_all:yogsothothium_ore")
  public static final Block block = null;
  
  public BlockYogsothothiumOre(GctAllContent instance) {
    super(instance, 68);
  }
  
  public void initElements() {
    registerBlockWithItem(BlockCustom::new, "yogsothothium_ore");
  }
  
  
  public static class BlockCustom extends Block {
    public BlockCustom() {
      super(Material.ROCK);
      setTranslationKey("yogsothothium_ore");
      setSoundType(SoundType.STONE);
      setHarvestLevel("pickaxe", 11);
      setHardness(30.0F);
      setResistance(4000.0F);
      setLightLevel(0.0F);
      setLightOpacity(255);
      setCreativeTab(GctAllCreativeTab.TAB);
    }
  }
}

