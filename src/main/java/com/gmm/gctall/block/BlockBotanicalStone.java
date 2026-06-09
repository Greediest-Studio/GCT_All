package com.gmm.gctall.block;

import com.gmm.gctall.common.GctAllCreativeTab;

import java.util.List;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.util.RegistrationHelper;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Tag
public class BlockBotanicalStone extends GctAllElement {
  @ObjectHolder("gct_all:botanical_stone")
  public static final Block block = null;
  
  public BlockBotanicalStone(GctAllContent instance) {
    super(instance, 306);
  }
  
  public void initElements() {
    this.elements.blocks.add(() -> (Block)(new BlockCustom()).setRegistryName("botanical_stone"));
    this.elements.items.add(() -> RegistrationHelper.itemBlock(block));
  }
  
  @SideOnly(Side.CLIENT)
  public void registerModels(ModelRegistryEvent event) {
    RegistrationHelper.registerBlockItemModel(block, "botanical_stone");
  }
  
  public static class BlockCustom extends Block {
    public BlockCustom() {
      super(Material.ROCK);
      setTranslationKey("botanical_stone");
      setSoundType(SoundType.STONE);
      setHarvestLevel("pickaxe", 12);
      setHardness(200.0F);
      setResistance(2000000.0F);
      setLightLevel(0.0F);
      setLightOpacity(255);
      setCreativeTab(GctAllCreativeTab.TAB);
    }
    
    public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
      super.addInformation(itemstack, world, list, flag);
      list.add("\u00A7e\u8574\u542B\u7740\u81EA\u7136\u7684\u5E9E\u5927\u80FD\u91CF\u3002");
    }
    
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
      drops.add(new ItemStack(BlockAlfStone.block, 1));
    }
  }
}

