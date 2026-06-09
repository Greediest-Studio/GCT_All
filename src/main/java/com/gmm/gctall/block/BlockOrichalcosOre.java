package com.gmm.gctall.block;

import com.gmm.gctall.common.GctAllCreativeTab;

import com.google.common.base.Predicate;
import java.util.Random;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.util.RegistrationHelper;
import com.gmm.gctall.world.dimension.WorldAlfheim;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Tag
public class BlockOrichalcosOre extends GctAllElement {
  @ObjectHolder("gct_all:orichalcos_ore")
  public static final Block block = null;
  
  public BlockOrichalcosOre(GctAllContent instance) {
    super(instance, 248);
  }
  
  public void initElements() {
    this.elements.blocks.add(() -> (Block)(new BlockCustom()).setRegistryName("orichalcos_ore"));
    this.elements.items.add(() -> RegistrationHelper.itemBlock(block));
  }
  
  @SideOnly(Side.CLIENT)
  public void registerModels(ModelRegistryEvent event) {
    RegistrationHelper.registerBlockItemModel(block, "orichalcos_ore");
  }
  
  public void generateWorld(Random random, int chunkX, int chunkZ, World world, int dimID, IChunkGenerator cg, IChunkProvider cp) {
    boolean dimensionCriteria = false;
    if (dimID == WorldAlfheim.DIMID)
      dimensionCriteria = true; 
    if (!dimensionCriteria)
      return; 
    for (int i = 0; i < 1; i++) {
      int x = chunkX + random.nextInt(16);
      int y = random.nextInt(64) + 0;
      int z = chunkZ + random.nextInt(16);
      (new WorldGenMinable(block.getDefaultState(), 12, new Predicate<IBlockState>() {
            public boolean apply(IBlockState blockAt) {
              boolean blockCriteria = false;
              if (blockAt.getBlock() == BlockAlfStone.block.getDefaultState().getBlock())
                blockCriteria = true; 
              return blockCriteria;
            }
          })).generate(world, random, new BlockPos(x, y, z));
    } 
  }
  
  public static class BlockCustom extends Block {
    public BlockCustom() {
      super(Material.ROCK);
      setTranslationKey("orichalcos_ore");
      setSoundType(SoundType.STONE);
      setHarvestLevel("pickaxe", 12);
      setHardness(5.0F);
      setResistance(6.0F);
      setLightLevel(0.33333334F);
      setLightOpacity(255);
      setCreativeTab(GctAllCreativeTab.TAB);
    }
  }
}

