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
public class BlockReversedAlfDirt extends GctAllElement {
  @ObjectHolder("gct_all:reversed_alf_dirt")
  public static final Block block = null;
  
  public BlockReversedAlfDirt(GctAllContent instance) {
    super(instance, 272);
  }
  
  public void initElements() {
    this.elements.blocks.add(() -> (Block)(new BlockCustom()).setRegistryName("reversed_alf_dirt"));
    this.elements.items.add(() -> RegistrationHelper.itemBlock(block));
  }
  
  @SideOnly(Side.CLIENT)
  public void registerModels(ModelRegistryEvent event) {
    RegistrationHelper.registerBlockItemModel(block, "reversed_alf_dirt");
  }
  
  public static class BlockCustom extends Block {
    public BlockCustom() {
      super(Material.GROUND);
      setTranslationKey("reversed_alf_dirt");
      setSoundType(SoundType.GROUND);
      setHarvestLevel("shovel", 1);
      setHardness(0.5F);
      setResistance(0.5F);
      setLightLevel(0.0F);
      setLightOpacity(255);
      setCreativeTab(GctAllCreativeTab.TAB);
    }
  }
}

