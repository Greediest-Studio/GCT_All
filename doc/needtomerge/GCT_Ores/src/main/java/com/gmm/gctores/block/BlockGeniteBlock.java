
package com.gmm.gctores.block;

import com.gmm.gctores.creativetab.TabCTab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class BlockGeniteBlock extends ElementsGctOresMod.ModElement
{
    @GameRegistry.ObjectHolder("gct_ores:genite_block")
    public static final Block block;
    
    public BlockGeniteBlock(final ElementsGctOresMod instance) {
        super(instance, 41);
    }
    
    @Override
    public void initElements() {
        this.elements.blocks.add(() -> (Block)new BlockCustom().setRegistryName("genite_block"));
        this.elements.items.add(() -> (Item)new ItemBlock(BlockGeniteBlock.block).setRegistryName(BlockGeniteBlock.block.getRegistryName()));
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerModels(final ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockGeniteBlock.block), 0, new ModelResourceLocation("gct_ores:genite_block", "inventory"));
    }
    
    static {
        block = null;
    }
    
    public static class BlockCustom extends Block
    {
        public BlockCustom() {
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
}
