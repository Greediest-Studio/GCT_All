package com.gmm.gctall.block;

import com.gmm.gctall.creativetab.TabCTabWitheric;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
public class BlockStormyMetalBlock extends Block {
    public static final Block block = new BlockStormyMetalBlock();

    public BlockStormyMetalBlock() {
    super(Material.IRON);
    this.setTranslationKey("stormy_metal_block");
    this.setSoundType(SoundType.METAL);
    this.setHarvestLevel("pickaxe", 0);
    this.setHardness(5.0f);
    this.setResistance(10.0f);
    this.setLightLevel(0.0f);
    this.setLightOpacity(15);
    this.setCreativeTab(TabCTabWitheric.tab);

    }
}