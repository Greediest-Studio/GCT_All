package com.gmm.gctall.block;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.client.util.ITooltipFlag;
import java.util.List;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTabWitheric;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
public class BlockOrderedFusionCore extends Block {
    public static final Block block = new BlockOrderedFusionCore();

    public BlockOrderedFusionCore() {
    super(Material.ROCK);
    this.setTranslationKey("ordered_fusion_core");
    this.setSoundType(SoundType.STONE);
    this.setHarvestLevel("pickaxe", 13);
    this.setHardness(50.0f);
    this.setResistance(200000.0f);
    this.setLightLevel(1.0f);
    this.setLightOpacity(0);
    this.setCreativeTab(TabCTabWitheric.tab);

    }



    public void addInformation(final ItemStack itemstack, final World world, final List<String> list, final ITooltipFlag flag) {
    super.addInformation(itemstack, world, (List)list, flag);
    list.add("\u7528\u5b83\u6765\u805a\u5408\u79e9\u5e8f\u4e4b\u7269\uff01");
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getRenderLayer() {
    return BlockRenderLayer.CUTOUT;
    }

    public boolean isOpaqueCube(final IBlockState state) {
    return false;
    }

    public boolean canConnectRedstone(final IBlockState state, final IBlockAccess world, final BlockPos pos, final EnumFacing side) {
    return true;
    }

}
