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
public class BlockPrimordialVisReceiver extends GctAllElement {
  @ObjectHolder("gct_all:primordial_vis_receiver")
  public static final Block block = null;
  
  public BlockPrimordialVisReceiver(GctAllContent instance) {
    super(instance, 58);
  }
  
  public void initElements() {
    this.elements.blocks.add(() -> (Block)(new BlockCustom()).setRegistryName("primordial_vis_receiver"));
    this.elements.items.add(() -> RegistrationHelper.itemBlock(block));
  }
  
  @SideOnly(Side.CLIENT)
  public void registerModels(ModelRegistryEvent event) {
    RegistrationHelper.registerBlockItemModel(block, "primordial_vis_receiver");
  }
  
  public static class BlockCustom extends Block {
    public BlockCustom() {
      super(Material.ROCK);
      setTranslationKey("primordial_vis_receiver");
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

