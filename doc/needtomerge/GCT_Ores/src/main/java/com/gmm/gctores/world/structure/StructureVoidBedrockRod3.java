
package com.gmm.gctores.world.structure;

import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.Block;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.ResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import com.gmm.gctores.world.WorldDIM100;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.World;
import java.util.Random;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class StructureVoidBedrockRod3 extends ElementsGctOresMod.ModElement
{
    public StructureVoidBedrockRod3(final ElementsGctOresMod instance) {
        super(instance, 363);
    }
    
    @Override
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
        if (random.nextInt(1000000) + 1 <= 100000) {
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
                    if (((ResourceLocation)Biome.REGISTRY.getNameForObject(biome)).equals(new ResourceLocation("gct_ores:void_hill"))) {
                        biomeCriteria = true;
                    }
                    if (biomeCriteria) {
                        if (world.isRemote) {
                            return;
                        }
                        final Template template = ((WorldServer)world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(), new ResourceLocation("gct_ores", "void_bdr_3"));
                        if (template == null) {
                            return;
                        }
                        final Rotation rotation = Rotation.values()[random.nextInt(3)];
                        final Mirror mirror = Mirror.values()[random.nextInt(2)];
                        final BlockPos spawnTo = new BlockPos(j, m + 0, l);
                        final IBlockState iblockstate = world.getBlockState(spawnTo);
                        world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
                        template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(rotation).setMirror(mirror).setChunk((ChunkPos)null).setReplacedBlock((Block)null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
                    }
                }
            }
        }
    }
}
