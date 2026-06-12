package com.gmm.gctall.common.world.structure;

import java.util.Random;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AirborneTemplateStructure extends TemplateStructureFeature {
    private final int minHeightAboveSurface;
    private final int randomHeight;
    private final int yOffset;

    protected AirborneTemplateStructure(int dimensionId, int chance, String templateName, int minHeightAboveSurface,
            int randomHeight, int yOffset) {
        super(dimensionId, chance, templateName);
        this.minHeightAboveSurface = minHeightAboveSurface;
        this.randomHeight = randomHeight;
        this.yOffset = yOffset;
    }

    protected AirborneTemplateStructure(int dimensionId, int chance, StructureTemplateId templateId,
            int minHeightAboveSurface, int randomHeight, int yOffset) {
        super(dimensionId, chance, templateId);
        this.minHeightAboveSurface = minHeightAboveSurface;
        this.randomHeight = randomHeight;
        this.yOffset = yOffset;
    }

    @Override
    protected BlockPos findOrigin(Random random, int chunkX, int chunkZ, World world) {
        int x = StructureGenerationHelper.randomChunkX(random, chunkX);
        int z = StructureGenerationHelper.randomChunkZ(random, chunkZ);
        int surfaceY = StructureGenerationHelper.findSurfaceY(world, x, z, false);
        int y = surfaceY + minHeightAboveSurface + random.nextInt(randomHeight) + yOffset;
        return new BlockPos(x, y, z);
    }
}
