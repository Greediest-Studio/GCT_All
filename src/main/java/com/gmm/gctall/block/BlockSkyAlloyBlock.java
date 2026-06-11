package com.gmm.gctall.block;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
public class BlockSkyAlloyBlock extends Block {
    public static final Block block = new BlockSkyAlloyBlock();

    public BlockSkyAlloyBlock() {
    super(Material.IRON);
    this.setTranslationKey("sky_alloy_block");
    this.setSoundType(SoundType.METAL);
    this.setHarvestLevel("pickaxe", 10);
    this.setHardness(24.0f);
    this.setResistance(10.0f);
    this.setLightLevel(0.0f);
    this.setLightOpacity(12);
    this.setCreativeTab(TabCTab.tab);

    }



    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getRenderLayer() {
    return BlockRenderLayer.CUTOUT_MIPPED;
    }

    public boolean isOpaqueCube(final IBlockState state) {
    return false;
    }

}
