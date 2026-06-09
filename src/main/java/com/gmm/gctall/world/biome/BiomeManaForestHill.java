package com.gmm.gctall.world.biome;

import java.util.Random;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.block.BlockManaDirt;
import com.gmm.gctall.block.BlockManaGrass;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@Tag
public class BiomeManaForestHill extends GctAllElement {
  @ObjectHolder("gct_all:mana_forest_hill")
  public static final BiomeGenCustom biome = null;
  
  public BiomeManaForestHill(GctAllContent instance) {
    super(instance, 238);
  }
  
  public void initElements() {
    this.elements.biomes.add(() -> new BiomeGenCustom());
  }
  
  public void init(FMLInitializationEvent event) {
    BiomeDictionary.addTypes(biome, new BiomeDictionary.Type[] { BiomeDictionary.Type.FOREST });
    BiomeManager.addSpawnBiome(biome);
    BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(biome, 3));
  }
  
  static class BiomeGenCustom extends Biome {
    public BiomeGenCustom() {
      super((new Biome.BiomeProperties("Mana Forest Hill")).setRainfall(0.5F).setBaseHeight(0.4F).setWaterColor(-16750900).setHeightVariation(1.0F)
          .setTemperature(0.5F));
      setRegistryName("mana_forest_hill");
      this.topBlock = BlockManaGrass.block.getDefaultState();
      this.fillerBlock = BlockManaDirt.block.getDefaultState();
      this.decorator.treesPerChunk = 0;
      this.decorator.flowersPerChunk = 8;
      this.decorator.grassPerChunk = 10;
      this.decorator.mushroomsPerChunk = 2;
      this.decorator.bigMushroomsPerChunk = 1;
      this.decorator.reedsPerChunk = 0;
      this.decorator.cactiPerChunk = 0;
      this.decorator.sandPatchesPerChunk = 1;
      this.decorator.gravelPatchesPerChunk = 1;
      this.spawnableMonsterList.clear();
      this.spawnableCreatureList.clear();
      this.spawnableWaterCreatureList.clear();
      this.spawnableCaveCreatureList.clear();
    }
    
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
      return super.getRandomTreeFeature(rand);
    }
  }
}

