package com.gmm.gctall.common.world.structure;

import com.gmm.gctall.common.world.dimension.WorldTheVoid;
import com.gmm.gctall.common.world.biome.BiomeVoidHill;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;

public class StructureVoidBedrockRod1 extends BlockFilteredSurfaceTemplateStructure {
    public StructureVoidBedrockRod1() {
        super(WorldTheVoid.DIMID, 300000, GctAllStructureTemplates.VOID_BEDROCK_ROD_1, Blocks.BEDROCK, BlockPos.ORIGIN.up(),
                BiomeVoidHill.biome);
    }
}
