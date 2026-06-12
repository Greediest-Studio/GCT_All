
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
public class BiomeVoidPlain extends ElementsGctOresMod.ModElement
{
    @GameRegistry.ObjectHolder("gct_ores:void_plain")
    public static final BiomeGenCustom biome;
    
    public BiomeVoidPlain(final ElementsGctOresMod instance) {
        super(instance, 359);
    }
    
    @Override
    public void initElements() {
        this.elements.biomes.add(() -> new BiomeGenCustom());
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
        BiomeDictionary.addTypes((Biome)BiomeVoidPlain.biome, new BiomeDictionary.Type[] { BiomeDictionary.Type.WASTELAND, BiomeDictionary.Type.VOID, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DEAD });
    }
    
    static {
        biome = null;
    }
    
    static class BiomeGenCustom extends Biome
    {
        public BiomeGenCustom() {
            super(new Biome.BiomeProperties("Void Plain").setRainfall(0.5f).setBaseHeight(0.3f).setWaterColor(-3355444).setHeightVariation(1.2f).setTemperature(2.0f));
            this.setRegistryName("void_plain");
            this.topBlock = Blocks.BEDROCK.getDefaultState();
            this.fillerBlock = Blocks.BEDROCK.getDefaultState();
            this.decorator.treesPerChunk = 0;
            this.decorator.flowersPerChunk = 0;
            this.decorator.grassPerChunk = 0;
            this.decorator.mushroomsPerChunk = 0;
            this.decorator.bigMushroomsPerChunk = 0;
            this.decorator.reedsPerChunk = 0;
            this.decorator.cactiPerChunk = 0;
            this.decorator.sandPatchesPerChunk = 0;
            this.decorator.gravelPatchesPerChunk = 0;
            this.spawnableMonsterList.clear();
            this.spawnableCreatureList.clear();
            this.spawnableWaterCreatureList.clear();
            this.spawnableCaveCreatureList.clear();
        }
        
        @SideOnly(Side.CLIENT)
        public int getGrassColorAtPos(final BlockPos pos) {
            return -10066330;
        }
        
        @SideOnly(Side.CLIENT)
        public int getFoliageColorAtPos(final BlockPos pos) {
            return -10066330;
        }
        
        @SideOnly(Side.CLIENT)
        public int getSkyColorByTemp(final float currentTemperature) {
            return -10066330;
        }
        
        public WorldGenAbstractTree getRandomTreeFeature(final Random rand) {
            return super.getRandomTreeFeature(rand);
        }
    }
}
