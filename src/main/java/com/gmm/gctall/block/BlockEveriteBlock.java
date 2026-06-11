package com.gmm.gctall.block;

import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
public class BlockEveriteBlock extends Block {
    public static final Block block = new BlockEveriteBlock();

    public BlockEveriteBlock() {
    super(Material.IRON);
    this.setTranslationKey("everite_block");
    this.setSoundType(SoundType.METAL);
    this.setHarvestLevel("pickaxe", 12);
    this.setHardness(20.0f);
    this.setResistance(10.0f);
    this.setLightLevel(0.8f);
    this.setLightOpacity(15);
    this.setCreativeTab(TabCTab.tab);

    }
}