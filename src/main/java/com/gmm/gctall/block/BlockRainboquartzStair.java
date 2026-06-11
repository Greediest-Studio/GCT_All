package com.gmm.gctall.block;

import net.minecraft.util.BlockRenderLayer;
import com.gmm.gctall.creativetab.TabCTabBuilding;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.Block;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockRainboquartzStair extends BlockStairs {
    public static final Block block = new BlockRainboquartzStair();

    public BlockRainboquartzStair() {
    super(new Block(Material.ROCK).getDefaultState());
    this.setTranslationKey("rainboquartz_stair");
    this.setSoundType(SoundType.STONE);
    this.setHarvestLevel("pickaxe", 0);
    this.setHardness(2.0f);
    this.setResistance(20.0f);
    this.setLightLevel(0.0f);
    this.setLightOpacity(15);
    this.setCreativeTab(TabCTabBuilding.tab);

    }



    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getRenderLayer() {
    return BlockRenderLayer.CUTOUT;
    }

}
