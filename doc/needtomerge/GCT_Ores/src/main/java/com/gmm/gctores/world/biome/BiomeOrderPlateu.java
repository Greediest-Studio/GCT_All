
package com.gmm.gctores.world.biome;

import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import java.util.Random;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.util.math.BlockPos;
import com.gmm.gctores.block.BlockOrderStone;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class BiomeOrderPlateu extends ElementsGctOresMod.ModElement
{
    @GameRegistry.ObjectHolder("gct_ores:order_plateu")
    public static final BiomeGenCustom biome;
    
    public BiomeOrderPlateu(final ElementsGctOresMod instance) {
        super(instance, 485);
    }
    
    @Override
    public void initElements() {
        this.elements.biomes.add(() -> new BiomeGenCustom());
    }
    
    @Override
    public void init(final FMLInitializationEvent event) {
    }
    
    static {
        biome = null;
    }
    
    static class BiomeGenCustom extends Biome
    {
        public BiomeGenCustom() {
            super(new Biome.BiomeProperties("Order Plateu").setRainfall(0.0f).setBaseHeight(3.0f).setHeightVariation(0.2f).setTemperature(0.5f));
            this.setRegistryName("order_plateu");
            this.topBlock = BlockOrderStone.block.getDefaultState();
            this.fillerBlock = BlockOrderStone.block.getDefaultState();
            this.decorator.treesPerChunk = 1;
            this.decorator.flowersPerChunk = 4;
            this.decorator.grassPerChunk = 4;
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
            return -1;
        }
        
        @SideOnly(Side.CLIENT)
        public int getFoliageColorAtPos(final BlockPos pos) {
            return -1;
        }
        
        @SideOnly(Side.CLIENT)
        public int getSkyColorByTemp(final float currentTemperature) {
            return -1;
        }
        
        public WorldGenAbstractTree getRandomTreeFeature(final Random rand) {
            return super.getRandomTreeFeature(rand);
        }
    }
}
