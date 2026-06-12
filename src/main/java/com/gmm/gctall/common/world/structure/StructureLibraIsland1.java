package com.gmm.gctall.common.world.structure;

import com.gmm.gctall.common.world.biome.BiomeLibraIsland;
import com.gmm.gctall.common.world.dimension.WorldStarland;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class StructureLibraIsland1 extends AirborneTemplateStructure {
    public StructureLibraIsland1() {
        super(WorldStarland.DIMID, 1000000, GctAllStructureTemplates.ASTRAL_ISLAND_1, 17, 50, 0);
    }

    @Override
    protected boolean canGenerateAt(World world, BlockPos origin) {
        return hasBiome(world, origin, BiomeLibraIsland.biome);
    }
}
