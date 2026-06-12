package com.gmm.gctall.common.blocks;

import com.gmm.gctall.misc.GctAllCreativeTab;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

  public class BlockCorruptdirt extends Block {
  public static final Block block = new BlockCorruptdirt();

  public BlockCorruptdirt() {
    super(Material.GROUND);
    setTranslationKey("corruptdirt");
    setSoundType(SoundType.GROUND);
    setHarvestLevel("shovel", 6);
    setHardness(3.0F);
    setResistance(10.0F);
    setLightLevel(0.0F);
    setLightOpacity(255);
    setCreativeTab(GctAllCreativeTab.TAB);
  }
}
