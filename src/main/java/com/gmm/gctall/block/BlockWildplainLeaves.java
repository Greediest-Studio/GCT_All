package com.gmm.gctall.block;

import com.gmm.gctall.common.GctAllCreativeTab;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

  public class BlockWildplainLeaves extends Block {
  public static final Block block = new BlockWildplainLeaves();

  public BlockWildplainLeaves() {
    super(Material.LEAVES);
    setTranslationKey("wildplain_leaves");
    setSoundType(SoundType.PLANT);
    setHardness(0.2F);
    setResistance(0.2F);
    setLightLevel(0.0F);
    setLightOpacity(255);
    setCreativeTab(GctAllCreativeTab.TAB);
  }

  @SideOnly(Side.CLIENT)
  public BlockRenderLayer getRenderLayer() {
    return BlockRenderLayer.CUTOUT;
  }

  public boolean isOpaqueCube(IBlockState state) {
    return false;
  }
}
