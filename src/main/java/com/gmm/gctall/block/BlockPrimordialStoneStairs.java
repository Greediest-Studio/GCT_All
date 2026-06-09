package com.gmm.gctall.block;

import com.gmm.gctall.common.GctAllCreativeTab;

import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.util.RegistrationHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Tag
public class BlockPrimordialStoneStairs extends GctAllElement {
  @ObjectHolder("gct_all:primordial_stone_stairs")
  public static final Block block = null;
  
  public BlockPrimordialStoneStairs(GctAllContent instance) {
    super(instance, 61);
  }
  
  public void initElements() {
    this.elements.blocks.add(() -> (Block)(new BlockCustom()).setRegistryName("primordial_stone_stairs"));
    this.elements.items.add(() -> RegistrationHelper.itemBlock(block));
  }
  
  @SideOnly(Side.CLIENT)
  public void registerModels(ModelRegistryEvent event) {
    RegistrationHelper.registerBlockItemModel(block, "primordial_stone_stairs");
  }
  
  public static class BlockCustom extends BlockStairs {
    public BlockCustom() {
      super((new Block(Material.ROCK)).getDefaultState());
      setTranslationKey("primordial_stone_stairs");
      setSoundType(SoundType.STONE);
      setHarvestLevel("pickaxe", 4);
      setHardness(2.0F);
      setResistance(10.0F);
      setLightLevel(0.0F);
      setLightOpacity(255);
      setCreativeTab(GctAllCreativeTab.TAB);
    }
  }
}

