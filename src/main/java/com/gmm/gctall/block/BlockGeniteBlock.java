package com.gmm.gctall.block;

import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
public class BlockGeniteBlock extends Block {
    public static final Block block = new BlockGeniteBlock();

    public BlockGeniteBlock() {
    super(Material.IRON);
    this.setTranslationKey("genite_block");
    this.setSoundType(SoundType.METAL);
    this.setHarvestLevel("pickaxe", 6);
    this.setHardness(10.0f);
    this.setResistance(10.0f);
    this.setLightLevel(0.0f);
    this.setLightOpacity(15);
    this.setCreativeTab(TabCTab.tab);

    }
}