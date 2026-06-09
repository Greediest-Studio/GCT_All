package com.gmm.gctall.block;

import com.gmm.gctall.common.GctAllCreativeTab;

import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import com.gmm.gctall.util.RegistrationHelper;

@Tag
public class BlockAlfSand extends GctAllElement {
  @ObjectHolder("gct_all:alf_sand")
  public static final Block block = null;
  
  public BlockAlfSand(GctAllContent instance) {
    super(instance, 227);
  }
  
  public void initElements() {
    this.elements.blocks.add(() -> (Block)(new BlockCustom()).setRegistryName("alf_sand"));
    this.elements.items.add(() -> RegistrationHelper.itemBlock(block));
  }
  
  @SideOnly(Side.CLIENT)
  public void registerModels(ModelRegistryEvent event) {
    RegistrationHelper.registerBlockItemModel(block, "alf_sand");
  }
  
  public static class BlockCustom extends BlockFalling {
    public BlockCustom() {
      super(Material.SAND);
      setTranslationKey("alf_sand");
      setSoundType(SoundType.SAND);
      setHarvestLevel("shovel", 0);
      setHardness(0.5F);
      setResistance(0.5F);
      setLightLevel(0.0F);
      setLightOpacity(255);
      setCreativeTab(GctAllCreativeTab.TAB);
    }
  }
}

