package com.gmm.gctall.block;

import com.gmm.gctall.common.GctAllCreativeTab;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.annotation.Nullable;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.procedure.ProcedureBlueFireEntityCollidesInTheBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Tag
public class BlockBlueFire extends GctAllElement {
  @ObjectHolder("gct_all:blue_fire")
  public static final Block block = null;
  
  public BlockBlueFire(GctAllContent instance) {
    super(instance, 77);
  }
  
  public void initElements() {
    registerBlockWithItem(BlockCustom::new, "blue_fire");
  }
  
  
  public static class BlockCustom extends BlockFalling {
    public BlockCustom() {
      super(Material.CLOTH);
      setTranslationKey("blue_fire");
      setSoundType(SoundType.CLOTH);
      setHardness(1.0F);
      setResistance(10.0F);
      setLightLevel(1.0F);
      setLightOpacity(0);
      setCreativeTab(GctAllCreativeTab.TAB);
    }
    
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getRenderLayer() {
      return BlockRenderLayer.CUTOUT;
    }
    
    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
      return NULL_AABB;
    }
    
    public boolean isPassable(IBlockAccess worldIn, BlockPos pos) {
      return true;
    }
    
    public boolean isFullCube(IBlockState state) {
      return false;
    }
    
    public boolean isOpaqueCube(IBlockState state) {
      return false;
    }
    
    public boolean isReplaceable(IBlockAccess blockAccess, BlockPos pos) {
      return true;
    }
    
    public int quantityDropped(Random random) {
      return 0;
    }
    
    public void onEntityCollision(World world, BlockPos pos, IBlockState state, Entity entity) {
      super.onEntityCollision(world, pos, state, entity);
      int x = pos.getX();
      int y = pos.getY();
      int z = pos.getZ();
      Map<String, Object> $_dependencies = new HashMap<>();
      $_dependencies.put("x", Integer.valueOf(x));
      $_dependencies.put("y", Integer.valueOf(y));
      $_dependencies.put("z", Integer.valueOf(z));
      $_dependencies.put("world", world);
      ProcedureBlueFireEntityCollidesInTheBlock.executeProcedure($_dependencies);
    }
  }
}

