package com.gmm.gctall.world.structure;

import com.gmm.gctall.block.BlockOrderLiquid;
import com.gmm.gctall.block.BlockOrderCrystalOre;
import com.gmm.gctall.block.BlockWitheriumOreEnd;
import com.gmm.gctall.block.BlockWitheriumOreNether;
import com.gmm.gctall.block.BlockWitheriumOreOverworld;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class GctAllStructureGenerator implements IWorldGenerator {
    private final StructureDIM54Portal1 dim54Portal1 = new StructureDIM54Portal1();
    private final StructureDIM54Portal2 dim54Portal2 = new StructureDIM54Portal2();
    private final StructureSeekAltarStructure seekAltar = new StructureSeekAltarStructure();
    private final StructureStrChurch strChurch = new StructureStrChurch();
    private final StructureStrBar strBar = new StructureStrBar();
    private final StructureStrBlacksmith strBlacksmith = new StructureStrBlacksmith();
    private final StructureStrFarm strFarm = new StructureStrFarm();
    private final StructureStrFarmhouse strFarmhouse = new StructureStrFarmhouse();
    private final StructureStrHouse strHouse = new StructureStrHouse();
    private final StructureStrLibarary strLibarary = new StructureStrLibarary();
    private final StructureStrStorage strStorage = new StructureStrStorage();
    private final StructureStrTower1 strTower1 = new StructureStrTower1();
    private final StructureStrTower2 strTower2 = new StructureStrTower2();
    private final StructureHeavenStonePostSmall heavenStonePostSmall = new StructureHeavenStonePostSmall();
    private final StructureHeavenStonePostSmall2 heavenStonePostSmall2 = new StructureHeavenStonePostSmall2();
    private final StructureHeavenStonePostLarge heavenStonePostLarge = new StructureHeavenStonePostLarge();
    private final StructureHeavenPortal heavenPortal = new StructureHeavenPortal();
    private final StructureReversedDungeon reversedDungeon = new StructureReversedDungeon();
    private final StructureElvenPost elvenPost = new StructureElvenPost();
    private final StructureLibraIsland1 libraIsland1 = new StructureLibraIsland1();
    private final StructureLibraIsland2 libraIsland2 = new StructureLibraIsland2();

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
            IChunkProvider chunkProvider) {
        int blockX = chunkX * 16;
        int blockZ = chunkZ * 16;
        int dimensionId = world.provider.getDimension();

        dim54Portal1.generateWorld(random, blockX, blockZ, world, dimensionId, chunkGenerator, chunkProvider);
        dim54Portal2.generateWorld(random, blockX, blockZ, world, dimensionId, chunkGenerator, chunkProvider);
        seekAltar.generateWorld(random, blockX, blockZ, world, dimensionId, chunkGenerator, chunkProvider);
        strChurch.generateWorld(random, blockX, blockZ, world, dimensionId, chunkGenerator, chunkProvider);
        strBar.generateWorld(random, blockX, blockZ, world, dimensionId, chunkGenerator, chunkProvider);
        strBlacksmith.generateWorld(random, blockX, blockZ, world, dimensionId, chunkGenerator, chunkProvider);
        strFarm.generateWorld(random, blockX, blockZ, world, dimensionId, chunkGenerator, chunkProvider);
        strFarmhouse.generateWorld(random, blockX, blockZ, world, dimensionId, chunkGenerator, chunkProvider);
        strHouse.generateWorld(random, blockX, blockZ, world, dimensionId, chunkGenerator, chunkProvider);
        strLibarary.generateWorld(random, blockX, blockZ, world, dimensionId, chunkGenerator, chunkProvider);
        strStorage.generateWorld(random, blockX, blockZ, world, dimensionId, chunkGenerator, chunkProvider);
        strTower1.generateWorld(random, blockX, blockZ, world, dimensionId, chunkGenerator, chunkProvider);
        strTower2.generateWorld(random, blockX, blockZ, world, dimensionId, chunkGenerator, chunkProvider);
        heavenStonePostSmall.generateWorld(random, blockX, blockZ, world, dimensionId, chunkGenerator, chunkProvider);
        heavenStonePostSmall2.generateWorld(random, blockX, blockZ, world, dimensionId, chunkGenerator, chunkProvider);
        heavenStonePostLarge.generateWorld(random, blockX, blockZ, world, dimensionId, chunkGenerator, chunkProvider);
        heavenPortal.generateWorld(random, blockX, blockZ, world, dimensionId, chunkGenerator, chunkProvider);
        reversedDungeon.generateWorld(random, blockX, blockZ, world, dimensionId, chunkGenerator, chunkProvider);
        elvenPost.generateWorld(random, blockX, blockZ, world, dimensionId, chunkGenerator, chunkProvider);
        libraIsland1.generateWorld(random, blockX, blockZ, world, dimensionId, chunkGenerator, chunkProvider);
        libraIsland2.generateWorld(random, blockX, blockZ, world, dimensionId, chunkGenerator, chunkProvider);
        BlockOrderLiquid.generateWorld(random, blockX, blockZ, world, dimensionId, chunkGenerator, chunkProvider);
        BlockOrderCrystalOre.generateWorld(random, blockX, blockZ, world, dimensionId, chunkGenerator, chunkProvider);
        BlockWitheriumOreEnd.generateWorld(random, blockX, blockZ, world, dimensionId, chunkGenerator, chunkProvider);
        BlockWitheriumOreNether.generateWorld(random, blockX, blockZ, world, dimensionId, chunkGenerator, chunkProvider);
        BlockWitheriumOreOverworld.generateWorld(random, blockX, blockZ, world, dimensionId, chunkGenerator, chunkProvider);
    }
}
