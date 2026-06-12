
package com.gmm.gctores.block;

import com.gmm.gctores.creativetab.TabCTabBuilding;
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
public class BlockShalloiteBlock extends ElementsGctOresMod.ModElement
{
    @GameRegistry.ObjectHolder("gct_ores:shalloite_block")
    public static final Block block;
    
    public BlockShalloiteBlock(final ElementsGctOresMod instance) {
        super(instance, 476);
    }
    
    @Override
    public void initElements() {
        this.elements.blocks.add(() -> (Block)new BlockCustom().setRegistryName("shalloite_block"));
        this.elements.items.add(() -> (Item)new ItemBlock(BlockShalloiteBlock.block).setRegistryName(BlockShalloiteBlock.block.getRegistryName()));
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerModels(final ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockShalloiteBlock.block), 0, new ModelResourceLocation("gct_ores:shalloite_block", "inventory"));
    }
    
    static {
        block = null;
    }
    
    public static class BlockCustom extends Block
    {
        public BlockCustom() {
            super(Material.ROCK);
            this.setTranslationKey("shalloite_block");
            this.setSoundType(SoundType.STONE);
            this.setHarvestLevel("pickaxe", 0);
            this.setHardness(2.0f);
            this.setResistance(20.0f);
            this.setLightLevel(0.0f);
            this.setLightOpacity(15);
            this.setCreativeTab(TabCTabBuilding.tab);
        }
    }
}
