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
public class BlockSeekFinder extends GctAllElement {
  @ObjectHolder("gct_all:seek_finder")
  public static final Block block = null;
  
  public BlockSeekFinder(GctAllContent instance) {
    super(instance, 65);
  }
  
  public void initElements() {
    registerBlockWithItem(BlockCustom::new, "seek_finder");
  }
  
  
  public static class BlockCustom extends Block {
    public BlockCustom() {
      super(Material.ROCK);
      setTranslationKey("seek_finder");
      setSoundType(SoundType.STONE);
      setHarvestLevel("pickaxe", 20);
      setHardness(500.0F);
      setResistance(1.0E7F);
      setLightLevel(0.0F);
      setLightOpacity(255);
      setCreativeTab(GctAllCreativeTab.TAB);
    }
  }
}

