package com.gmm.gctall.block;

import com.gmm.gctall.common.GctAllCreativeTab;

import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Tag
public class BlockWarprackStair extends GctAllElement {
  @ObjectHolder("gct_all:warprack_stair")
  public static final Block block = null;
  
  public BlockWarprackStair(GctAllContent instance) {
    super(instance, 92);
  }
  
  public void initElements() {
    registerBlockWithItem(BlockCustom::new, "warprack_stair");
  }
  
  
  public static class BlockCustom extends BlockStairs {
    public BlockCustom() {
      super((new Block(Material.ROCK)).getDefaultState());
      setTranslationKey("warprack_stair");
      setSoundType(SoundType.STONE);
      setHarvestLevel("pickaxe", 10);
      setHardness(15.0F);
      setResistance(4000.0F);
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
}

