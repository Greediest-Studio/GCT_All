package com.gmm.gctall.common.world.biome;

import java.util.Random;
import com.gmm.gctall.common.blocks.BlockReversedAlfDirt;
import com.gmm.gctall.common.blocks.BlockReversedAlfGrass;
import com.gmm.gctall.common.blocks.BlockReversedDreamwoodLeaves;
import com.gmm.gctall.common.blocks.BlockReversedDreamwoodLog;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BiomeReversedForest extends Biome {
  public static final BiomeReversedForest biome = new BiomeReversedForest();
  public BiomeReversedForest() {
    super((new Biome.BiomeProperties("Alfheim Forest(Reversed)")).setRainfall(0.5F).setBaseHeight(0.2F).setWaterColor(-16777216)
        .setHeightVariation(0.4F).setTemperature(0.5F));
    setRegistryName("reversed_forest");
    this.topBlock = BlockReversedAlfGrass.block.getDefaultState();
    this.fillerBlock = BlockReversedAlfDirt.block.getDefaultState();
    this.decorator.treesPerChunk = 8;
    this.decorator.flowersPerChunk = 2;
    this.decorator.grassPerChunk = 16;
    this.decorator.mushroomsPerChunk = 0;
    this.decorator.bigMushroomsPerChunk = 2;
    this.decorator.reedsPerChunk = 0;
    this.decorator.cactiPerChunk = 0;
    this.decorator.sandPatchesPerChunk = 0;
    this.decorator.gravelPatchesPerChunk = 0;
    this.spawnableMonsterList.clear();
    this.spawnableCreatureList.clear();
    this.spawnableWaterCreatureList.clear();
    this.spawnableCaveCreatureList.clear();
  }

  @SideOnly(Side.CLIENT)
  public int getGrassColorAtPos(BlockPos pos) {
    return -8716033;
  }

  @SideOnly(Side.CLIENT)
  public int getFoliageColorAtPos(BlockPos pos) {
    return -8716033;
  }

  @SideOnly(Side.CLIENT)
  public int getSkyColorByTemp(float currentTemperature) {
    return -8716033;
  }

  public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
    return new BiomeReversedForest.CustomTree();
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
        if ((ground != BlockReversedAlfGrass.block.getDefaultState().getBlock() && ground != BlockReversedAlfDirt.block
          .getDefaultState().getBlock()) || (ground2 != BlockReversedAlfGrass.block
          .getDefaultState().getBlock() && ground2 != BlockReversedAlfDirt.block
          .getDefaultState().getBlock()))
          return false;
        IBlockState state = world.getBlockState(position.down());
        if (position.getY() < world.getHeight() - height - 1) {
          world.setBlockState(position.down(), BlockReversedAlfDirt.block.getDefaultState(), 2);
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
                    .getBlock() == BlockReversedDreamwoodLeaves.block.getDefaultState().getBlock())
                    setBlockAndNotifyAdequately(world, blockpos, BlockReversedDreamwoodLeaves.block.getDefaultState());
                }
              }
            }
          }
          for (genh = 0; genh < height; genh++) {
            BlockPos genhPos = position.up(genh);
            state = world.getBlockState(genhPos);
            if (state.getBlock().isAir(state, (IBlockAccess)world, genhPos) || state.getBlock() == Blocks.VINE.getDefaultState().getBlock() || state
              .getBlock() == BlockReversedDreamwoodLeaves.block.getDefaultState().getBlock()) {
              setBlockAndNotifyAdequately(world, position.up(genh), BlockReversedDreamwoodLog.block.getDefaultState());
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
                  .getBlock() == BlockReversedDreamwoodLeaves.block.getDefaultState().getBlock()) {
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
      setBlockAndNotifyAdequately(world, pos, Blocks.VINE.getDefaultState());
      int i = 5;
      for (BlockPos blockpos = pos.down(); world.isAirBlock(blockpos) && i > 0; i--) {
        setBlockAndNotifyAdequately(world, blockpos, Blocks.VINE.getDefaultState());
        blockpos = blockpos.down();
      }
    }

    protected boolean canGrowInto(Block blockType) {
      return (blockType.getDefaultState().getMaterial() == Material.AIR || blockType == BlockReversedDreamwoodLog.block
        .getDefaultState().getBlock() || blockType == BlockReversedDreamwoodLeaves.block
        .getDefaultState().getBlock() || blockType == BlockReversedAlfGrass.block
        .getDefaultState().getBlock() || blockType == BlockReversedAlfDirt.block
        .getDefaultState().getBlock());
    }

    protected void setDirtAt(World world, BlockPos pos) {
      if (world.getBlockState(pos).getBlock() != BlockReversedAlfDirt.block.getDefaultState().getBlock())
        setBlockAndNotifyAdequately(world, pos, BlockReversedAlfDirt.block.getDefaultState());
    }

    public boolean isReplaceable(World world, BlockPos pos) {
      IBlockState state = world.getBlockState(pos);
      return (state.getBlock().isAir(state, (IBlockAccess)world, pos) || canGrowInto(state.getBlock()) || state.getBlock().isReplaceable((IBlockAccess)world, pos));
    }
  }
}
