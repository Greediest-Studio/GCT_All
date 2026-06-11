package com.gmm.gctall.block;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
public class BlockTerrasteelMachineFrame extends Block {
    public static final Block block = new BlockTerrasteelMachineFrame();

    public BlockTerrasteelMachineFrame() {
    super(Material.IRON);
    this.setTranslationKey("terrasteel_machine_frame");
    this.setSoundType(SoundType.METAL);
    this.setHarvestLevel("pickaxe", 2);
    this.setHardness(1.5f);
    this.setResistance(20.0f);
    this.setLightLevel(0.0f);
    this.setLightOpacity(0);
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
