
package com.gmm.gctores.world.biome;

import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import java.util.Random;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.util.math.BlockPos;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class BiomeNowhere extends ElementsGctOresMod.ModElement
{
    @GameRegistry.ObjectHolder("gct_ores:nowhere")
    public static final BiomeGenCustom biome;
    
    public BiomeNowhere(final ElementsGctOresMod instance) {
        super(instance, 368);
    }
    
    @Override
    public void initElements() {
        this.elements.biomes.add(() -> new BiomeGenCustom());
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        BiomeDictionary.addTypes((Biome)BiomeNowhere.biome, new BiomeDictionary.Type[] { BiomeDictionary.Type.FOREST, BiomeDictionary.Type.MESA, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.SWAMP, BiomeDictionary.Type.SANDY, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.WASTELAND, BiomeDictionary.Type.BEACH, BiomeDictionary.Type.VOID, BiomeDictionary.Type.HOT, BiomeDictionary.Type.COLD, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.WET, BiomeDictionary.Type.DRY, BiomeDictionary.Type.SAVANNA, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.SPOOKY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.NETHER, BiomeDictionary.Type.END, BiomeDictionary.Type.MUSHROOM, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.RARE, BiomeDictionary.Type.OCEAN, BiomeDictionary.Type.RIVER, BiomeDictionary.Type.WATER });
    }
    
    static {
        biome = null;
    }
    
    static class BiomeGenCustom extends Biome
    {
        public BiomeGenCustom() {
            super(new Biome.BiomeProperties("Nowhere").setRainfall(0.0f).setBaseHeight(0.8f).setWaterColor(-16777216).setHeightVariation(0.6f).setTemperature(0.5f));
            this.setRegistryName("nowhere");
            this.topBlock = Blocks.OBSIDIAN.getDefaultState();
            this.fillerBlock = Blocks.OBSIDIAN.getDefaultState();
            this.decorator.treesPerChunk = 0;
            this.decorator.flowersPerChunk = 0;
            this.decorator.grassPerChunk = 0;
            this.decorator.mushroomsPerChunk = 0;
            this.decorator.bigMushroomsPerChunk = 0;
            this.decorator.reedsPerChunk = 0;
            this.decorator.cactiPerChunk = 1;
            this.decorator.sandPatchesPerChunk = 32;
            this.decorator.gravelPatchesPerChunk = 64;
            this.spawnableMonsterList.clear();
            this.spawnableCreatureList.clear();
            this.spawnableWaterCreatureList.clear();
            this.spawnableCaveCreatureList.clear();
        }
        
        @SideOnly(Side.CLIENT)
        public int getGrassColorAtPos(final BlockPos pos) {
            return -6750055;
        }
        
        @SideOnly(Side.CLIENT)
        public int getFoliageColorAtPos(final BlockPos pos) {
            return -6750055;
        }
        
        @SideOnly(Side.CLIENT)
        public int getSkyColorByTemp(final float currentTemperature) {
            return -6750055;
        }
        
        public WorldGenAbstractTree getRandomTreeFeature(final Random rand) {
            return super.getRandomTreeFeature(rand);
        }
    }
}
