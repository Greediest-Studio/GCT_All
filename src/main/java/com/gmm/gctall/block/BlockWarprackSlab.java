package com.gmm.gctall.block;

import com.gmm.gctall.common.GctAllCreativeTab;

import java.util.Random;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Tag
public class BlockWarprackSlab extends GctAllElement {
  @ObjectHolder("gct_all:warprack_slab")
  public static final Block block = null;
  
  @ObjectHolder("gct_all:warprack_slab_double")
  public static final Block block_slab_double = null;
  
  public BlockWarprackSlab(GctAllContent instance) {
    super(instance, 93);
  }
  
  public void initElements() {
    final BlockSlab[] slabs = new BlockSlab[2];
    registerBlock(() -> {
      BlockSlab slab = (BlockSlab)(new BlockCustom()).setRegistryName("warprack_slab");
      slabs[0] = slab;
      return slab;
    });
    registerBlock(() -> {
      BlockSlab doubleSlab = (BlockSlab)(new BlockCustom.Double()).setRegistryName("warprack_slab_double");
      slabs[1] = doubleSlab;
      return doubleSlab;
    });
    registerItem(() -> (Item)(new ItemSlab(slabs[0], slabs[0], slabs[1])).setRegistryName(slabs[0].getRegistryName()), "warprack_slab");
  }
  
  
  public static class BlockCustom extends BlockSlab {
    public BlockCustom() {
      super(Material.ROCK);
      setTranslationKey("warprack_slab");
      setSoundType(SoundType.STONE);
      setHarvestLevel("pickaxe", 10);
      setHardness(15.0F);
      setResistance(4000.0F);
      setLightLevel(0.0F);
      setLightOpacity(255);
      setCreativeTab(GctAllCreativeTab.TAB);
      IBlockState state = this.blockState.getBaseState().withProperty((IProperty)VARIANT, Variant.DEFAULT);
      if (!isDouble())
        state = state.withProperty((IProperty)BlockSlab.HALF, (Comparable)BlockSlab.EnumBlockHalf.BOTTOM); 
      setDefaultState(state);
      this.useNeighborBrightness = !isDouble();
    }
    
    public static final PropertyEnum<Variant> VARIANT = PropertyEnum.create("variant", Variant.class);
    
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
      return Item.getItemFromBlock(BlockWarprackSlab.block);
    }
    
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
      return new ItemStack(BlockWarprackSlab.block);
    }
    
    protected BlockStateContainer createBlockState() {
      return isDouble() ? new BlockStateContainer((Block)this, new IProperty[] { (IProperty)VARIANT }) : new BlockStateContainer((Block)this, new IProperty[] { (IProperty)HALF, (IProperty)VARIANT });
    }
    
    public IBlockState getStateFromMeta(int meta) {
      if (isDouble())
        return getDefaultState(); 
      return getDefaultState().withProperty((IProperty)HALF, (Comparable)BlockSlab.EnumBlockHalf.values()[meta % 2]);
    }
    
    public int getMetaFromState(IBlockState state) {
      if (isDouble())
        return 0; 
      return ((BlockSlab.EnumBlockHalf)state.getValue((IProperty)HALF)).ordinal();
    }
    
    public String getTranslationKey(int meta) {
      return getTranslationKey();
    }
    
    public IProperty<?> getVariantProperty() {
      return (IProperty<?>)VARIANT;
    }
    
    public Comparable<?> getTypeForItem(ItemStack stack) {
      return Variant.DEFAULT;
    }
    
    public boolean isDouble() {
      return false;
    }
    
    public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face) {
      if (isDouble())
        return true; 
      return super.doesSideBlockRendering(state, world, pos, face);
    }
    
    public enum Variant implements IStringSerializable {
      DEFAULT;
      
      public String getName() {
        return "default";
      }
    }
    
    public static class Double extends BlockCustom {
      public boolean isDouble() {
        return true;
      }
    }
    
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getRenderLayer() {
      return BlockRenderLayer.CUTOUT;
    }
    
    public boolean isOpaqueCube(IBlockState state) {
      return false;
    }
  }
  
  public static class Double extends BlockCustom {
    public boolean isDouble() {
      return true;
    }
  }
}

