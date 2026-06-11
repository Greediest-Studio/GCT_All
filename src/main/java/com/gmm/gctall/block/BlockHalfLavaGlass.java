package com.gmm.gctall.block;

import com.gmm.gctall.creativetab.TabCTabBuilding;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
public class BlockHalfLavaGlass extends Block {
    public static final Block block = new BlockHalfLavaGlass();

    public BlockHalfLavaGlass() {
    super(Material.GLASS);
    this.setTranslationKey("half_lava_glass");
    this.setSoundType(SoundType.GLASS);
    this.setHardness(1.0f);
    this.setResistance(10.0f);
    this.setLightLevel(1.0f);
    this.setLightOpacity(0);
    this.setCreativeTab(TabCTabBuilding.tab);

    }
}