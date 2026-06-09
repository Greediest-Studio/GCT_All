package com.gmm.gctall.block;

import net.minecraft.creativetab.CreativeTabs;

import com.gmm.gctall.common.GctAllCreativeTab;

import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.util.RegistrationHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Tag
public class BlockPolarisiteDarkWall extends GctAllElement {
  @ObjectHolder("gct_all:polarisite_dark_wall")
  public static final Block block = null;
  
  public BlockPolarisiteDarkWall(GctAllContent instance) {
    super(instance, 334);
  }
  
  public void initElements() {
    this.elements.blocks.add(() -> (Block)(new BlockCustom()).setRegistryName("polarisite_dark_wall"));
    this.elements.items.add(() -> RegistrationHelper.itemBlock(block));
  }
  
  @SideOnly(Side.CLIENT)
  public void registerModels(ModelRegistryEvent event) {
    RegistrationHelper.registerBlockItemModel(block, "polarisite_dark_wall");
  }
  
  public static class BlockCustom extends BlockWall {
    public BlockCustom() {
      super(new Block(Material.ROCK));
      setTranslationKey("polarisite_dark_wall");
      setSoundType(SoundType.STONE);
      setHarvestLevel("pickaxe", 8);
      setHardness(15.0F);
      setResistance(4000.0F);
      setLightLevel(0.0F);
      setLightOpacity(255);
      setCreativeTab(GctAllCreativeTab.TAB);
    }
    
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> items) {
      items.add(new ItemStack((Block)this));
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

