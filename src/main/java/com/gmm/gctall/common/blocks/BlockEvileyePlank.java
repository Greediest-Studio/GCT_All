package com.gmm.gctall.common.blocks;

import com.gmm.gctall.misc.GctAllCreativeTab;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

  public class BlockEvileyePlank extends Block {
  public static final Block block = new BlockEvileyePlank();

  public BlockEvileyePlank() {
    super(Material.WOOD);
    setTranslationKey("evileye_plank");
    setSoundType(SoundType.WOOD);
    setHarvestLevel("axe", -1);
    setHardness(2.0F);
    setResistance(3.0F);
    setLightLevel(0.0F);
    setLightOpacity(255);
    setCreativeTab(GctAllCreativeTab.TAB);
  }
}
