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
public class BlockWarprack extends GctAllElement {
  @ObjectHolder("gct_all:warprack")
  public static final Block block = null;
  
  public BlockWarprack(GctAllContent instance) {
    super(instance, 36);
  }
  
  public void initElements() {
    registerBlockWithItem(BlockCustom::new, "warprack");
  }
  
  
  public static class BlockCustom extends Block {
    public BlockCustom() {
      super(Material.ROCK);
      setTranslationKey("warprack");
      setSoundType(SoundType.STONE);
      setHarvestLevel("pickaxe", 10);
      setHardness(15.0F);
      setResistance(4000.0F);
      setLightLevel(0.0F);
      setLightOpacity(255);
      setCreativeTab(GctAllCreativeTab.TAB);
    }
  }
}

