package com.gmm.gctall.block;

import com.gmm.gctall.common.GctAllCreativeTab;

import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.util.RegistrationHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Tag
public class BlockCrystalsand extends GctAllElement {
  @ObjectHolder("gct_all:crystalsand")
  public static final Block block = null;
  
  public BlockCrystalsand(GctAllContent instance) {
    super(instance, 320);
  }
  
  public void initElements() {
    this.elements.blocks.add(() -> (Block)(new BlockCustom()).setRegistryName("crystalsand"));
    this.elements.items.add(() -> RegistrationHelper.itemBlock(block));
  }
  
  @SideOnly(Side.CLIENT)
  public void registerModels(ModelRegistryEvent event) {
    RegistrationHelper.registerBlockItemModel(block, "crystalsand");
  }
  
  public static class BlockCustom extends BlockFalling {
    public BlockCustom() {
      super(Material.SAND);
      setTranslationKey("crystalsand");
      setSoundType(SoundType.SAND);
      setHarvestLevel("shovel", 0);
      setHardness(1.8F);
      setResistance(10.0F);
      setLightLevel(0.6666667F);
      setLightOpacity(255);
      setCreativeTab(GctAllCreativeTab.TAB);
    }
  }
}

