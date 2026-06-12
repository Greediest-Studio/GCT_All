package com.gmm.gctall.common.world.structure;

import com.gmm.gctall.common.world.biome.BiomeAlfheimPlain;
import com.gmm.gctall.common.world.dimension.WorldAlfheim;

public class StructureElvenPost extends BiomeSurfaceTemplateStructure {
    public StructureElvenPost() {
        super(WorldAlfheim.DIMID, 10000, GctAllStructureTemplates.ELVEN_POST, 0, BiomeAlfheimPlain.biome);
    }
}
