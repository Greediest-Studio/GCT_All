package com.gmm.gctall.common.world.structure;

import com.gmm.gctall.common.world.dimension.WorldOrderland;
import com.gmm.gctall.common.world.biome.BiomeOrderBasin;
import com.gmm.gctall.common.world.biome.BiomeOrderPlain;

public class StructureOrderStoneRod2 extends BiomeSurfaceTemplateStructure {
    public StructureOrderStoneRod2() {
        super(WorldOrderland.DIMID, 50000, GctAllStructureTemplates.ORDER_ROD_2, 0, BiomeOrderBasin.biome, BiomeOrderPlain.biome);
    }
}
