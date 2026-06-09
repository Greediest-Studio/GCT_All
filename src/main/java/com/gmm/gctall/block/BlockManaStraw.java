package com.gmm.gctall.block;

import net.minecraft.creativetab.CreativeTabs;

import com.gmm.gctall.common.GctAllCreativeTab;

import java.util.Random;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.util.RegistrationHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Tag
public class BlockManaStraw extends GctAllElement {
  @ObjectHolder("gct_all:mana_straw")
  public static final Block block = null;
  
  public BlockManaStraw(GctAllContent instance) {
    super(instance, 387);
  }
  
  public void initElements() {
    this.elements.blocks.add(() -> new BlockCustomFlower());
    this.elements.items.add(() -> RegistrationHelper.itemBlock(block));
  }
  
  @SideOnly(Side.CLIENT)
  public void registerModels(ModelRegistryEvent event) {
    RegistrationHelper.registerBlockItemModel(block, "mana_straw");
  }
  
  public void generateWorld(Random random, int chunkX, int chunkZ, World world, int dimID, IChunkGenerator cg, IChunkProvider cp) {
    boolean dimensionCriteria = false;
    if (dimID == 0)
      dimensionCriteria = true; 
    if (!dimensionCriteria)
      return; 
    boolean biomeCriteria = false;
    Biome biome = world.getBiome(new BlockPos(chunkX, 128, chunkZ));
    if (((ResourceLocation)Biome.REGISTRY.getNameForObject(biome)).equals(new ResourceLocation("gct_all:mana_forest")))
      biomeCriteria = true; 
    if (((ResourceLocation)Biome.REGISTRY.getNameForObject(biome)).equals(new ResourceLocation("gct_all:mana_forest_hill")))
      biomeCriteria = true; 
    if (!biomeCriteria)
      return; 
    for (int i = 0; i < 20; i++) {
      int l6 = chunkX + random.nextInt(16) + 8;
      int i11 = random.nextInt(128);
      int l14 = chunkZ + random.nextInt(16) + 8;
      (new WorldGenFlowers((BlockFlower)block, BlockFlower.EnumFlowerType.DANDELION)).generate(world, random, new BlockPos(l6, i11, l14));
    } 
  }
  
  public static class BlockCustomFlower extends BlockFlower {
    public BlockCustomFlower() {
      setSoundType(SoundType.PLANT);
      setCreativeTab(GctAllCreativeTab.TAB);
      setHardness(0.0F);
      setResistance(0.0F);
      setLightLevel(0.0F);
      setTranslationKey("mana_straw");
      setRegistryName("mana_straw");
    }
    
    public boolean isReplaceable(IBlockAccess blockAccess, BlockPos pos) {
      return true;
    }
    
    public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
      return 100;
    }
    
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
      drops.add(new ItemStack(Blocks.AIR, 1));
    }
    
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
      return new ItemStack(Item.getItemFromBlock((Block)this), 1, damageDropped(state));
    }
    
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
      return EnumPlantType.Plains;
    }
    
    public BlockFlower.EnumFlowerColor getBlockType() {
      return BlockFlower.EnumFlowerColor.YELLOW;
    }
    
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
      for (BlockFlower.EnumFlowerType blockflower$enumflowertype : BlockFlower.EnumFlowerType.getTypes(getBlockType()))
        list.add(new ItemStack((Block)this, 1, blockflower$enumflowertype.getMeta())); 
    }
  }
}

