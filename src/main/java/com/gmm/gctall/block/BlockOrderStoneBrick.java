package com.gmm.gctall.block;

import com.gmm.gctall.creativetab.TabCTabBuilding;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
public class BlockOrderStoneBrick extends Block {
    public static final Block block = new BlockOrderStoneBrick();

    public BlockOrderStoneBrick() {
    super(Material.ROCK);
    this.setTranslationKey("order_stone_brick");
    this.setSoundType(SoundType.STONE);
    this.setHarvestLevel("pickaxe", 12);
    this.setHardness(50.0f);
    this.setResistance(4000.0f);
    this.setLightLevel(0.0f);
    this.setLightOpacity(15);
    this.setCreativeTab(TabCTabBuilding.tab);

    }
}