package com.gmm.gctall.block;

import com.gmm.gctall.creativetab.TabCTabBuilding;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
public class BlockShalloiteBlockChiseled extends Block {
    public static final Block block = new BlockShalloiteBlockChiseled();

    public BlockShalloiteBlockChiseled() {
    super(Material.ROCK);
    this.setTranslationKey("shalloite_block_chiseled");
    this.setSoundType(SoundType.STONE);
    this.setHarvestLevel("pickaxe", 0);
    this.setHardness(2.0f);
    this.setResistance(20.0f);
    this.setLightLevel(0.0f);
    this.setLightOpacity(15);
    this.setCreativeTab(TabCTabBuilding.tab);

    }
}