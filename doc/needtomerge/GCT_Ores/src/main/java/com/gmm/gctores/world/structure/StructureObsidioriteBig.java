
package com.gmm.gctores.world.structure;

import net.minecraft.block.state.IBlockState;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.block.Block;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.WorldServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.World;
import java.util.Random;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class StructureObsidioriteBig extends ElementsGctOresMod.ModElement
{
    public StructureObsidioriteBig(final ElementsGctOresMod instance) {
        super(instance, 500);
    }
    
    @Override
    public void generateWorld(final Random random, final int i2, final int k2, final World world, final int dimID, final IChunkGenerator cg, final IChunkProvider cp) {
        boolean dimensionCriteria = false;
        final boolean isNetherType = false;
        if (dimID == 1) {
            dimensionCriteria = true;
        }
        if (!dimensionCriteria) {
            return;
        }
        if (random.nextInt(1000000) + 1 <= 500) {
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
                final int m = height + random.nextInt(50) + 16;
                if (world.isRemote) {
                    return;
                }
                final Template template = ((WorldServer)world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(), new ResourceLocation("gct_ores", "obisidiorite_big"));
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
