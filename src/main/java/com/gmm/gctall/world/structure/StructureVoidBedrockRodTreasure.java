
package com.gmm.gctall.world.structure;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.world.biome.Biome;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import com.gmm.gctall.world.WorldDIM100;
import com.gmm.gctall.world.biome.BiomeVoidHill;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.World;
import java.util.Random;
public class StructureVoidBedrockRodTreasure
{
    public void generateWorld(final Random random, final int i2, final int k2, final World world, final int dimID, final IChunkGenerator cg, final IChunkProvider cp) {
        boolean dimensionCriteria = false;
        boolean isNetherType = false;
        if (dimID == WorldDIM100.DIMID) {
            dimensionCriteria = true;
            isNetherType = false;
        }
        if (!dimensionCriteria) {
            return;
        }
        if (random.nextInt(1000000) + 1 <= 10000) {
            for (int count = random.nextInt(1) + 1, a = 0; a < count; ++a) {
                final int j = i2 + random.nextInt(16) + 8;
                final int l = k2 + random.nextInt(16) + 8;
                int height = 255;
                if (isNetherType) {
                    boolean notpassed = true;
                    while (height > 0) {
                        if (notpassed && (world.isAirBlock(new BlockPos(j, height, l)) || !world.getBlockState(new BlockPos(j, height, l)).getBlock().getMaterial(world.getBlockState(new BlockPos(j, height, l))).blocksMovement())) {
                            notpassed = false;
                        }
                        else if (!notpassed && !world.isAirBlock(new BlockPos(j, height, l)) && world.getBlockState(new BlockPos(j, height, l)).getBlock().getMaterial(world.getBlockState(new BlockPos(j, height, l))).blocksMovement()) {
                            break;
                        }
                        --height;
                    }
                }
                else {
                    while (height > 0) {
                        if (!world.isAirBlock(new BlockPos(j, height, l)) && world.getBlockState(new BlockPos(j, height, l)).getBlock().getMaterial(world.getBlockState(new BlockPos(j, height, l))).blocksMovement()) {
                            break;
                        }
                        --height;
                    }
                }
                final int m = height - 1;
                final IBlockState blockAt = world.getBlockState(new BlockPos(j, m + 1, l));
                boolean blockCriteria = false;
                final IBlockState require = Blocks.BEDROCK.getDefaultState();
                if (blockAt.getBlock() == require.getBlock()) {
                    blockCriteria = true;
                }
                if (blockCriteria) {
                    boolean biomeCriteria = false;
                    final Biome biome = world.getBiome(new BlockPos(j, m, l));
                    if (biome == BiomeVoidHill.biome) {
                        biomeCriteria = true;
                    }
                    if (biomeCriteria) {
                        if (world.isRemote) {
                            return;
                        }
                        final Rotation rotation = Rotation.values()[random.nextInt(3)];
                        final Mirror mirror = Mirror.values()[random.nextInt(2)];
                        final BlockPos spawnTo = new BlockPos(j, m + 0, l);
                        StructureGenerationHelper.placeTemplate(world, "void_bdr_t", spawnTo, rotation, mirror);
                    }
                }
            }
        }
    }
}



