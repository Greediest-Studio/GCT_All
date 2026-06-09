package com.gmm.gctall.block;

import com.gmm.gctall.common.GctAllCreativeTab;

import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.util.RegistrationHelper;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Tag
public class BlockCorruptdirt extends GctAllElement {
  @ObjectHolder("gct_all:corruptdirt")
  public static final Block block = null;
  
  public BlockCorruptdirt(GctAllContent instance) {
    super(instance, 49);
  }
  
  public void initElements() {
    this.elements.blocks.add(() -> (Block)(new BlockCustom()).setRegistryName("corruptdirt"));
    this.elements.items.add(() -> RegistrationHelper.itemBlock(block));
  }
  
  @SideOnly(Side.CLIENT)
  public void registerModels(ModelRegistryEvent event) {
    RegistrationHelper.registerBlockItemModel(block, "corruptdirt");
  }
  
  public static class BlockCustom extends Block {
    public BlockCustom() {
      super(Material.GROUND);
      setTranslationKey("corruptdirt");
      setSoundType(SoundType.GROUND);
      setHarvestLevel("shovel", 6);
      setHardness(3.0F);
      setResistance(10.0F);
      setLightLevel(0.0F);
      setLightOpacity(255);
      setCreativeTab(GctAllCreativeTab.TAB);
    }
  }
}

