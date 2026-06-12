
package com.gmm.gctores.block;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
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
public class BlockSkyAlloyBlock extends ElementsGctOresMod.ModElement
{
    @GameRegistry.ObjectHolder("gct_ores:sky_alloy_block")
    public static final Block block;
    
    public BlockSkyAlloyBlock(final ElementsGctOresMod instance) {
        super(instance, 36);
    }
    
    @Override
    public void initElements() {
        this.elements.blocks.add(() -> (Block)new BlockCustom().setRegistryName("sky_alloy_block"));
        this.elements.items.add(() -> (Item)new ItemBlock(BlockSkyAlloyBlock.block).setRegistryName(BlockSkyAlloyBlock.block.getRegistryName()));
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerModels(final ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockSkyAlloyBlock.block), 0, new ModelResourceLocation("gct_ores:sky_alloy_block", "inventory"));
    }
    
    static {
        block = null;
    }
    
    public static class BlockCustom extends Block
    {
        public BlockCustom() {
            super(Material.IRON);
            this.setTranslationKey("sky_alloy_block");
            this.setSoundType(SoundType.METAL);
            this.setHarvestLevel("pickaxe", 10);
            this.setHardness(24.0f);
            this.setResistance(10.0f);
            this.setLightLevel(0.0f);
            this.setLightOpacity(12);
            this.setCreativeTab(TabCTab.tab);
        }
        
        @SideOnly(Side.CLIENT)
        public BlockRenderLayer getRenderLayer() {
            return BlockRenderLayer.CUTOUT_MIPPED;
        }
        
        public boolean isOpaqueCube(final IBlockState state) {
            return false;
        }
    }
}
