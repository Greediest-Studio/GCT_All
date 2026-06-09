package com.gmm.gctall.world.biome;

import java.util.Random;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.block.BlockWarprack;
import com.gmm.gctall.entity.EntityRemnantWandering;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Tag
public class BiomeWarped extends GctAllElement {
  @ObjectHolder("gct_all:warped")
  public static final BiomeGenCustom biome = null;
  
  public BiomeWarped(GctAllContent instance) {
    super(instance, 38);
  }
  
  public void initElements() {
    registerBiome(() -> new BiomeGenCustom());
  }

  @Override
  public void init(FMLInitializationEvent event) {
    BiomeDictionary.addTypes(biome, Type.HOT, Type.PLAINS, Type.SAVANNA, Type.DRY);
  }
  
  static class BiomeGenCustom extends Biome {
    public BiomeGenCustom() {
      super((new Biome.BiomeProperties("Warped")).setRainfall(0.0F).setBaseHeight(3.0F).setWaterColor(-16751002).setHeightVariation(0.1F)
          .setTemperature(1.5F));
      setRegistryName("warped");
      this.topBlock = BlockWarprack.block.getDefaultState();
      this.fillerBlock = BlockWarprack.block.getDefaultState();
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
      this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityRemnantWandering.EntityCustom.class, 20, 4, 4));
    }
    
    @SideOnly(Side.CLIENT)
    public int getGrassColorAtPos(BlockPos pos) {
      return -16751002;
    }
    
    @SideOnly(Side.CLIENT)
    public int getFoliageColorAtPos(BlockPos pos) {
      return -16751002;
    }
    
    @SideOnly(Side.CLIENT)
    public int getSkyColorByTemp(float currentTemperature) {
      return -16751002;
    }
    
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
      return super.getRandomTreeFeature(rand);
    }
  }
}

