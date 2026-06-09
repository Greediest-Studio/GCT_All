package com.gmm.gctall.world.biome;

import java.util.Random;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.block.BlockAlfDirt;
import com.gmm.gctall.block.BlockAlfGrass;
import com.gmm.gctall.block.BlockDreamwoodLeaves;
import com.gmm.gctall.block.BlockDreamwoodLog;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@Tag
public class BiomeAlfheimPlainHill extends GctAllElement {
  @ObjectHolder("gct_all:alfheim_plain_hill")
  public static final BiomeGenCustom biome = null;
  
  public BiomeAlfheimPlainHill(GctAllContent instance) {
    super(instance, 239);
  }
  
  public void initElements() {
    this.elements.biomes.add(() -> new BiomeGenCustom());
  }
  
  public void init(FMLInitializationEvent event) {
    BiomeDictionary.addTypes(biome, new BiomeDictionary.Type[] { BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.MAGICAL });
  }
  
  static class BiomeGenCustom extends Biome {
    public BiomeGenCustom() {
      super((new Biome.BiomeProperties("Alfheim Hill")).setRainfall(0.5F).setBaseHeight(0.4F).setHeightVariation(0.8F).setTemperature(0.5F));
      setRegistryName("alfheim_plain_hill");
      this.topBlock = BlockAlfGrass.block.getDefaultState();
      this.fillerBlock = BlockAlfDirt.block.getDefaultState();
      this.decorator.treesPerChunk = 1;
      this.decorator.flowersPerChunk = 4;
      this.decorator.grassPerChunk = 4;
      this.decorator.mushroomsPerChunk = 0;
      this.decorator.bigMushroomsPerChunk = 0;
      this.decorator.reedsPerChunk = 0;
      this.decorator.cactiPerChunk = 0;
      this.decorator.sandPatchesPerChunk = 0;
      this.decorator.gravelPatchesPerChunk = 0;
      this.spawnableMonsterList.clear();
      this.spawnableCreatureList.clear();
      this.spawnableWaterCreatureList.clear();
      this.spawnableCaveCreatureList.clear();
    }
    
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
      return new BiomeAlfheimPlainHill.CustomTree();
    }
  }
  
  static class CustomTree extends WorldGenAbstractTree {
    CustomTree() {
      super(false);
    }
    
    public boolean generate(World world, Random rand, BlockPos position) {
      int height = rand.nextInt(5) + 7;
      boolean spawnTree = true;
      if (position.getY() >= 1 && position.getY() + height + 1 <= world.getHeight()) {
        for (int j = position.getY(); j <= position.getY() + 1 + height; j++) {
          int k = 1;
          if (j == position.getY())
            k = 0; 
          if (j >= position.getY() + height - 1)
            k = 2; 
          for (int px = position.getX() - k; px <= position.getX() + k && spawnTree; px++) {
            for (int pz = position.getZ() - k; pz <= position.getZ() + k && spawnTree; pz++) {
              if (j >= 0 && j < world.getHeight()) {
                if (!isReplaceable(world, new BlockPos(px, j, pz)))
                  spawnTree = false; 
              } else {
                spawnTree = false;
              } 
            } 
          } 
        } 
        if (!spawnTree)
          return false; 
        Block ground = world.getBlockState(position.add(0, -1, 0)).getBlock();
        Block ground2 = world.getBlockState(position.add(0, -2, 0)).getBlock();
        if ((ground != BlockAlfGrass.block.getDefaultState().getBlock() && ground != BlockAlfDirt.block.getDefaultState().getBlock()) || (ground2 != BlockAlfGrass.block
          .getDefaultState().getBlock() && ground2 != BlockAlfDirt.block
          .getDefaultState().getBlock()))
          return false; 
        IBlockState state = world.getBlockState(position.down());
        if (position.getY() < world.getHeight() - height - 1) {
          world.setBlockState(position.down(), BlockAlfDirt.block.getDefaultState(), 2);
          int genh;
          for (genh = position.getY() - 3 + height; genh <= position.getY() + height; genh++) {
            int i4 = genh - position.getY() + height;
            int j1 = (int)(1.0D - i4 * 0.5D);
            for (int k1 = position.getX() - j1; k1 <= position.getX() + j1; k1++) {
              for (int i2 = position.getZ() - j1; i2 <= position.getZ() + j1; i2++) {
                int j2 = i2 - position.getZ();
                if (Math.abs(position.getX()) != j1 || Math.abs(j2) != j1 || (rand.nextInt(2) != 0 && i4 != 0)) {
                  BlockPos blockpos = new BlockPos(k1, genh, i2);
                  state = world.getBlockState(blockpos);
                  if (state.getBlock().isAir(state, (IBlockAccess)world, blockpos) || state.getBlock().isLeaves(state, (IBlockAccess)world, blockpos) || state
                    .getBlock() == Blocks.VINE.getDefaultState().getBlock() || state
                    .getBlock() == BlockDreamwoodLeaves.block.getDefaultState().getBlock())
                    setBlockAndNotifyAdequately(world, blockpos, BlockDreamwoodLeaves.block.getDefaultState()); 
                } 
              } 
            } 
          } 
          for (genh = 0; genh < height; genh++) {
            BlockPos genhPos = position.up(genh);
            state = world.getBlockState(genhPos);
            if (state.getBlock().isAir(state, (IBlockAccess)world, genhPos) || state.getBlock() == Blocks.VINE.getDefaultState().getBlock() || state
              .getBlock() == BlockDreamwoodLeaves.block.getDefaultState().getBlock()) {
              setBlockAndNotifyAdequately(world, position.up(genh), BlockDreamwoodLog.block.getDefaultState());
              if (genh > 0) {
                if (rand.nextInt(3) > 0 && world.isAirBlock(position.add(-1, genh, 0)))
                  setBlockAndNotifyAdequately(world, position.add(-1, genh, 0), Blocks.VINE.getDefaultState()); 
                if (rand.nextInt(3) > 0 && world.isAirBlock(position.add(1, genh, 0)))
                  setBlockAndNotifyAdequately(world, position.add(1, genh, 0), Blocks.VINE.getDefaultState()); 
                if (rand.nextInt(3) > 0 && world.isAirBlock(position.add(0, genh, -1)))
                  setBlockAndNotifyAdequately(world, position.add(0, genh, -1), Blocks.VINE.getDefaultState()); 
                if (rand.nextInt(3) > 0 && world.isAirBlock(position.add(0, genh, 1)))
                  setBlockAndNotifyAdequately(world, position.add(0, genh, 1), Blocks.VINE.getDefaultState()); 
              } 
            } 
          } 
          for (genh = position.getY() - 3 + height; genh <= position.getY() + height; genh++) {
            int k4 = (int)(1.0D - (genh - position.getY() + height) * 0.5D);
            for (int genx = position.getX() - k4; genx <= position.getX() + k4; genx++) {
              for (int genz = position.getZ() - k4; genz <= position.getZ() + k4; genz++) {
                BlockPos bpos = new BlockPos(genx, genh, genz);
                state = world.getBlockState(bpos);
                if (state.getBlock().isLeaves(state, (IBlockAccess)world, bpos) || state
                  .getBlock() == BlockDreamwoodLeaves.block.getDefaultState().getBlock()) {
                  BlockPos blockpos1 = bpos.south();
                  BlockPos blockpos2 = bpos.west();
                  BlockPos blockpos3 = bpos.east();
                  BlockPos blockpos4 = bpos.north();
                  if (rand.nextInt(4) == 0 && world.isAirBlock(blockpos2))
                    addVines(world, blockpos2); 
                  if (rand.nextInt(4) == 0 && world.isAirBlock(blockpos3))
                    addVines(world, blockpos3); 
                  if (rand.nextInt(4) == 0 && world.isAirBlock(blockpos4))
                    addVines(world, blockpos4); 
                  if (rand.nextInt(4) == 0 && world.isAirBlock(blockpos1))
                    addVines(world, blockpos1); 
                } 
              } 
            } 
          } 
          return true;
        } 
        return false;
      } 
      return false;
    }
    
    private void addVines(World world, BlockPos pos) {
    }
    
    protected boolean canGrowInto(Block blockType) {
      return (blockType.getDefaultState().getMaterial() == Material.AIR || blockType == BlockDreamwoodLog.block.getDefaultState().getBlock() || blockType == BlockDreamwoodLeaves.block
        .getDefaultState().getBlock() || blockType == BlockAlfGrass.block
        .getDefaultState().getBlock() || blockType == BlockAlfDirt.block.getDefaultState().getBlock());
    }
    
    protected void setDirtAt(World world, BlockPos pos) {
      if (world.getBlockState(pos).getBlock() != BlockAlfDirt.block.getDefaultState().getBlock())
        setBlockAndNotifyAdequately(world, pos, BlockAlfDirt.block.getDefaultState()); 
    }
    
    public boolean isReplaceable(World world, BlockPos pos) {
      IBlockState state = world.getBlockState(pos);
      return (state.getBlock().isAir(state, (IBlockAccess)world, pos) || canGrowInto(state.getBlock()) || state.getBlock().isReplaceable((IBlockAccess)world, pos));
    }
  }
}

