package com.gmm.gctall.block;

import com.gmm.gctall.creativetab.TabCTabWitheric;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
public class BlockEquipmentWitheriumBlock extends Block {
    public static final Block block = new BlockEquipmentWitheriumBlock();

    public BlockEquipmentWitheriumBlock() {
    super(Material.IRON);
    this.setTranslationKey("equipment_witherium_block");
    this.setSoundType(SoundType.METAL);
    this.setHarvestLevel("pickaxe", 12);
    this.setHardness(30.0f);
    this.setResistance(4000.0f);
    this.setLightLevel(0.6666667f);
    this.setLightOpacity(15);
    this.setCreativeTab(TabCTabWitheric.tab);

    }
}