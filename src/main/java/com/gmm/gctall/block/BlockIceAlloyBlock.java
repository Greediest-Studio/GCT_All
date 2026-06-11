package com.gmm.gctall.block;

import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
public class BlockIceAlloyBlock extends Block {
    public static final Block block = new BlockIceAlloyBlock();

    public BlockIceAlloyBlock() {
    super(Material.IRON);
    this.setTranslationKey("ice_alloy_block");
    this.setSoundType(SoundType.METAL);
    this.setHarvestLevel("pickaxe", 10);
    this.setHardness(10.0f);
    this.setResistance(10.0f);
    this.setLightLevel(0.0f);
    this.setLightOpacity(15);
    this.setCreativeTab(TabCTab.tab);

    }
}