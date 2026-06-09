package com.gmm.gctall.world.biome;

import java.util.Random;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.block.BlockCrystalsand;
import com.gmm.gctall.block.BlockCrystalsandstone;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@Tag
public class BiomeScorpioDesert extends GctAllElement {
  @ObjectHolder("gct_all:scorpio_desert")
  public static final BiomeGenCustom biome = null;
  
  public BiomeScorpioDesert(GctAllContent instance) {
    super(instance, 346);
  }
  
  public void initElements() {
    this.elements.biomes.add(() -> new BiomeGenCustom());
  }
  
  public void init(FMLInitializationEvent event) {
    BiomeDictionary.addTypes(biome, new BiomeDictionary.Type[] { BiomeDictionary.Type.WASTELAND });
  }
  
  static class BiomeGenCustom extends Biome {
    public BiomeGenCustom() {
      super((new Biome.BiomeProperties("Scorpio Desert")).setRainfall(0.5F).setBaseHeight(0.2F).setHeightVariation(0.1F).setTemperature(0.5F));
      setRegistryName("scorpio_desert");
      this.topBlock = BlockCrystalsand.block.getDefaultState();
      this.fillerBlock = BlockCrystalsandstone.block.getDefaultState();
      this.decorator.treesPerChunk = 0;
      this.decorator.flowersPerChunk = 4;
      this.decorator.grassPerChunk = 8;
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
    
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
      return super.getRandomTreeFeature(rand);
    }
  }
}

