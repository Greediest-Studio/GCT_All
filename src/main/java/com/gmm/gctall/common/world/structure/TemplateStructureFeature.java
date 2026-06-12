package com.gmm.gctall.common.world.structure;

import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.block.Block;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;

public abstract class TemplateStructureFeature implements StructureFeature {
    protected static final int CHANCE_DENOMINATOR = 1_000_000;

    private final int dimensionId;
    private final int chance;
    private final StructureTemplateId templateId;
    private final int maxAttempts;
    @Nullable
    private final Rotation rotation;
    @Nullable
    private final Mirror mirror;

    protected TemplateStructureFeature(int dimensionId, int chance, String templateName) {
        this(dimensionId, chance, new StructureTemplateId(templateName));
    }

    protected TemplateStructureFeature(int dimensionId, int chance, StructureTemplateId templateId) {
        this(dimensionId, chance, templateId, 1);
    }

    protected TemplateStructureFeature(int dimensionId, int chance, String templateName, int maxAttempts) {
        this(dimensionId, chance, new StructureTemplateId(templateName), maxAttempts);
    }

    protected TemplateStructureFeature(int dimensionId, int chance, StructureTemplateId templateId, int maxAttempts) {
        this(dimensionId, chance, templateId, maxAttempts, null, null);
    }

    protected TemplateStructureFeature(int dimensionId, int chance, String templateName, @Nullable Rotation rotation,
            @Nullable Mirror mirror) {
        this(dimensionId, chance, new StructureTemplateId(templateName), rotation, mirror);
    }

    protected TemplateStructureFeature(int dimensionId, int chance, StructureTemplateId templateId,
            @Nullable Rotation rotation, @Nullable Mirror mirror) {
        this(dimensionId, chance, templateId, 1, rotation, mirror);
    }

    protected TemplateStructureFeature(int dimensionId, int chance, String templateName, int maxAttempts,
            @Nullable Rotation rotation, @Nullable Mirror mirror) {
        this(dimensionId, chance, new StructureTemplateId(templateName), maxAttempts, rotation, mirror);
    }

    protected TemplateStructureFeature(int dimensionId, int chance, StructureTemplateId templateId, int maxAttempts,
            @Nullable Rotation rotation, @Nullable Mirror mirror) {
        this.dimensionId = dimensionId;
        this.chance = chance;
        this.templateId = templateId;
        this.maxAttempts = maxAttempts;
        this.rotation = rotation;
        this.mirror = mirror;
    }

    @Override
    public final void generateWorld(Random random, int chunkX, int chunkZ, World world, int dimensionId,
            IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if (world.isRemote || dimensionId != this.dimensionId || !passesChance(random)) {
            return;
        }

        int count = random.nextInt(maxAttempts) + 1;
        for (int i = 0; i < count; i++) {
            BlockPos origin = findOrigin(random, chunkX, chunkZ, world);
            if (origin != null && canGenerateAt(world, origin)) {
                StructureGenerationHelper.placeTemplate(world, templateId, origin, getRotation(random), getMirror(random));
            }
        }
    }

    protected BlockPos findSurfaceOrigin(Random random, int chunkX, int chunkZ, World world, boolean netherStyle) {
        int x = StructureGenerationHelper.randomChunkX(random, chunkX);
        int z = StructureGenerationHelper.randomChunkZ(random, chunkZ);
        int y = StructureGenerationHelper.findSurfaceY(world, x, z, netherStyle);
        return new BlockPos(x, y, z);
    }

    protected boolean hasBiome(World world, BlockPos pos, Biome... biomes) {
        Biome current = world.getBiome(pos);
        for (Biome biome : biomes) {
            if (current == biome) {
                return true;
            }
        }
        return false;
    }

    protected boolean blockAt(World world, BlockPos pos, Block block) {
        return world.getBlockState(pos).getBlock() == block;
    }

    protected Rotation getRotation(Random random) {
        return rotation == null ? StructureGenerationHelper.randomRotation(random) : rotation;
    }

    protected Mirror getMirror(Random random) {
        return mirror == null ? StructureGenerationHelper.randomMirror(random) : mirror;
    }

    @Nullable
    protected abstract BlockPos findOrigin(Random random, int chunkX, int chunkZ, World world);

    protected boolean canGenerateAt(World world, BlockPos origin) {
        return true;
    }

    private boolean passesChance(Random random) {
        return chance > 0 && random.nextInt(CHANCE_DENOMINATOR) + 1 <= chance;
    }
}
