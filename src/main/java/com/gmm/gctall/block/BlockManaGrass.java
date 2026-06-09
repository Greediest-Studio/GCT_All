package com.gmm.gctall.block;

import com.gmm.gctall.common.GctAllCreativeTab;

import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.util.RegistrationHelper;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Tag
public class BlockManaGrass extends GctAllElement {
  @ObjectHolder("gct_all:mana_grass")
  public static final Block block = null;
  
  public BlockManaGrass(GctAllContent instance) {
    super(instance, 46);
  }
  
  public void initElements() {
    this.elements.blocks.add(() -> (Block)(new BlockCustom()).setRegistryName("mana_grass"));
    this.elements.items.add(() -> RegistrationHelper.itemBlock(block));
  }
  
  @SideOnly(Side.CLIENT)
  public void registerModels(ModelRegistryEvent event) {
    RegistrationHelper.registerBlockItemModel(block, "mana_grass");
  }
  
  public static class BlockCustom extends Block {
    public BlockCustom() {
      super(Material.GRASS);
      setTranslationKey("mana_grass");
      setSoundType(SoundType.GROUND);
      setHarvestLevel("shovel", 1);
      setHardness(0.5F);
      setResistance(0.5F);
      setLightLevel(0.0F);
      setLightOpacity(255);
      setCreativeTab(GctAllCreativeTab.TAB);
    }
    
    public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plantable) {
      return true;
    }
    
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
      drops.add(new ItemStack(BlockManaDirt.block, 1));
    }
  }
}

