package com.gmm.gctall.block;

import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
public class BlockChaoticDraconiumBlock extends Block {
    public static final Block block = new BlockChaoticDraconiumBlock();

    public BlockChaoticDraconiumBlock() {
    super(Material.IRON);
    this.setTranslationKey("chaotic_draconium_block");
    this.setSoundType(SoundType.METAL);
    this.setHarvestLevel("pickaxe", 10);
    this.setHardness(30.0f);
    this.setResistance(4000.0f);
    this.setLightLevel(0.06666667f);
    this.setLightOpacity(15);
    this.setCreativeTab(TabCTab.tab);

    }
}