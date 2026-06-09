package com.gmm.gctall.world.biome;

import java.util.Random;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.block.BlockDenseDarkstone;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
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
public class BiomeDarkerRealm extends GctAllElement {
  @ObjectHolder("gct_all:darkerrealm")
  public static final BiomeGenCustom biome = null;
  
  public BiomeDarkerRealm(GctAllContent instance) {
    super(instance, 2);
  }
  
  public void initElements() {
    registerBiome(() -> new BiomeGenCustom());
  }

  @Override
  public void init(FMLInitializationEvent event) {
    BiomeDictionary.addTypes(biome, Type.PLAINS, Type.DRY);
  }
  
  static class BiomeGenCustom extends Biome {
    public BiomeGenCustom() {
      super((new Biome.BiomeProperties("Darker Realm")).setRainfall(0.0F).setBaseHeight(0.4F).setWaterColor(-16751002).setHeightVariation(0.2F)
          .setTemperature(0.5F));
      setRegistryName("darkerrealm");
      this.topBlock = BlockDenseDarkstone.block.getDefaultState();
      this.fillerBlock = BlockDenseDarkstone.block.getDefaultState();
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
      this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityCreeper.class, 15, 1, 15));
      this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityZombie.class, 15, 1, 15));
      this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntitySkeleton.class, 15, 1, 15));
      this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityEnderman.class, 15, 1, 15));
      this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntitySpider.class, 15, 1, 15));
    }
    
    @SideOnly(Side.CLIENT)
    public int getGrassColorAtPos(BlockPos pos) {
      return -16777216;
    }
    
    @SideOnly(Side.CLIENT)
    public int getFoliageColorAtPos(BlockPos pos) {
      return -16777216;
    }
    
    @SideOnly(Side.CLIENT)
    public int getSkyColorByTemp(float currentTemperature) {
      return -10066330;
    }
    
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
      return super.getRandomTreeFeature(rand);
    }
  }
}

