package com.gmm.gctall.block;

import com.gmm.gctall.common.GctAllCreativeTab;

import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.util.RegistrationHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Tag
public class BlockCrystalsandstoneStairs extends GctAllElement {
  @ObjectHolder("gct_all:crystalsandstone_stairs")
  public static final Block block = null;
  
  public BlockCrystalsandstoneStairs(GctAllContent instance) {
    super(instance, 323);
  }
  
  public void initElements() {
    this.elements.blocks.add(() -> (Block)(new BlockCustom()).setRegistryName("crystalsandstone_stairs"));
    this.elements.items.add(() -> RegistrationHelper.itemBlock(block));
  }
  
  @SideOnly(Side.CLIENT)
  public void registerModels(ModelRegistryEvent event) {
    RegistrationHelper.registerBlockItemModel(block, "crystalsandstone_stairs");
  }
  
  public static class BlockCustom extends BlockStairs {
    public BlockCustom() {
      super((new Block(Material.ROCK)).getDefaultState());
      setTranslationKey("crystalsandstone_stairs");
      setSoundType(SoundType.STONE);
      setHarvestLevel("pickaxe", 0);
      setHardness(5.0F);
      setResistance(10.0F);
      setLightLevel(0.6666667F);
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

