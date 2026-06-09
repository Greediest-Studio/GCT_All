package com.gmm.gctall.block;

import com.gmm.gctall.common.GctAllCreativeTab;

import java.util.List;
import java.util.Random;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.util.RegistrationHelper;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Tag
public class BlockShubniggurathiumBlock extends GctAllElement {
  @ObjectHolder("gct_all:shubniggurathium_block")
  public static final Block block = null;
  
  public BlockShubniggurathiumBlock(GctAllContent instance) {
    super(instance, 29);
  }
  
  public void initElements() {
    this.elements.blocks.add(() -> (Block)(new BlockCustom()).setRegistryName("shubniggurathium_block"));
    this.elements.items.add(() -> RegistrationHelper.itemBlock(block));
  }
  
  @SideOnly(Side.CLIENT)
  public void registerModels(ModelRegistryEvent event) {
    RegistrationHelper.registerBlockItemModel(block, "shubniggurathium_block");
  }
  
  public static class BlockCustom extends Block {
    public BlockCustom() {
      super(Material.IRON);
      setTranslationKey("shubniggurathium_block");
      setSoundType(SoundType.METAL);
      setHarvestLevel("pickaxe", 11);
      setHardness(15.0F);
      setResistance(2000.0F);
      setLightLevel(0.0F);
      setLightOpacity(255);
      setCreativeTab(GctAllCreativeTab.TAB);
    }
    
    public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
      super.addInformation(itemstack, world, list, flag);
      list.add("\u00A7e\u8036\uFF01\u838E\u5E03\u00B7\u5C3C\u53E4\u62C9\u4E1D\uFF01");
    }
    
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random random) {
      super.randomDisplayTick(state, world, pos, random);
      EntityPlayerSP entityPlayerSP = (Minecraft.getMinecraft()).player;
      int x = pos.getX();
      int y = pos.getY();
      int z = pos.getZ();
      int i = x;
      int j = y;
      int k = z;
      for (int l = 0; l < 1; l++) {
        double d0 = i + 0.5D + (random.nextFloat() - 0.5D) * 0.5D;
        double d1 = j + 0.7D + (random.nextFloat() - 0.5D) * 0.5D + 0.5D;
        double d2 = k + 0.5D + (random.nextFloat() - 0.5D) * 0.5D;
        world.spawnParticle(EnumParticleTypes.SPELL, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
      } 
    }
  }
}

