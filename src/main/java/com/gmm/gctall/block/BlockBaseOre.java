package com.gmm.gctall.block;

import net.minecraft.creativetab.CreativeTabs;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockBaseOre extends Block {
  public BlockBaseOre(float hardness, float resistance, CreativeTabs creativeTab) {
    super(Material.ROCK);
    setSoundType(SoundType.STONE);
    setHarvestLevel("pickaxe", 3);
    setHardness(hardness);
    setResistance(resistance);
    setLightLevel(0.0F);
    setLightOpacity(15);
    setCreativeTab(creativeTab);
  }
}
