package com.gmm.gctall.block;

import com.gmm.gctall.common.GctAllCreativeTab;

import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.util.RegistrationHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Tag
public class BlockWildplainFence extends GctAllElement {
  @ObjectHolder("gct_all:wildplain_fence")
  public static final Block block = null;
  
  public BlockWildplainFence(GctAllContent instance) {
    super(instance, 211);
  }
  
  public void initElements() {
    this.elements.blocks.add(() -> (Block)(new BlockCustom()).setRegistryName("wildplain_fence"));
    this.elements.items.add(() -> RegistrationHelper.itemBlock(block));
  }
  
  @SideOnly(Side.CLIENT)
  public void registerModels(ModelRegistryEvent event) {
    RegistrationHelper.registerBlockItemModel(block, "wildplain_fence");
  }
  
  public static class BlockCustom extends BlockFence {
    public BlockCustom() {
      super(Material.WOOD, Material.WOOD.getMaterialMapColor());
      setTranslationKey("wildplain_fence");
      setSoundType(SoundType.WOOD);
      setHarvestLevel("axe", -1);
      setHardness(2.0F);
      setResistance(3.0F);
      setLightLevel(0.0F);
      setLightOpacity(255);
      setCreativeTab(GctAllCreativeTab.TAB);
    }
    
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getRenderLayer() {
      return BlockRenderLayer.CUTOUT;
    }
    
    public boolean isOpaqueCube(IBlockState state) {
      return false;
    }
  }
}

