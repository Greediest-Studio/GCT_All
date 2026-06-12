package com.gmm.gctall.common.world.structure;

import com.gmm.gctall.common.world.dimension.WorldOrderland;
import com.gmm.gctall.common.world.biome.BiomeOrderBasin;
import com.gmm.gctall.common.world.biome.BiomeOrderPlain;

public class StructureOrderStoneRod extends BiomeSurfaceTemplateStructure {
    public StructureOrderStoneRod() {
        super(WorldOrderland.DIMID, 100000, GctAllStructureTemplates.ORDER_ROD_1, 0, BiomeOrderBasin.biome, BiomeOrderPlain.biome);
    }
}
