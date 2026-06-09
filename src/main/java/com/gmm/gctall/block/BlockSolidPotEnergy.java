package com.gmm.gctall.block;

import com.gmm.gctall.common.GctAllCreativeTab;

import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@Tag
public class BlockSolidPotEnergy extends GctAllElement {
  @ObjectHolder("gct_all:solid_pot_energy")
  public static final Block block = null;
  
  public BlockSolidPotEnergy(GctAllContent instance) {
    super(instance, 73);
  }
  
  public void initElements() {
    registerBlockWithItem(BlockCustom::new, "solid_pot_energy");
  }
  
  
  public static class BlockCustom extends Block {
    public BlockCustom() {
      super(Material.IRON);
      setTranslationKey("solid_pot_energy");
      setSoundType(SoundType.METAL);
      setHarvestLevel("pickaxe", 1);
      setHardness(2.0F);
      setResistance(10.0F);
      setLightLevel(1.0F);
      setLightOpacity(255);
      setCreativeTab(GctAllCreativeTab.TAB);
    }
  }
}

