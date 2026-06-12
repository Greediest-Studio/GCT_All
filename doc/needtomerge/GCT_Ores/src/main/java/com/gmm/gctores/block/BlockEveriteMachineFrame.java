
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
public class BlockEveriteMachineFrame extends ElementsGctOresMod.ModElement
{
    @GameRegistry.ObjectHolder("gct_ores:everite_machine_frame")
    public static final Block block;
    
    public BlockEveriteMachineFrame(final ElementsGctOresMod instance) {
        super(instance, 68);
    }
    
    @Override
    public void initElements() {
        this.elements.blocks.add(() -> (Block)new BlockCustom().setRegistryName("everite_machine_frame"));
        this.elements.items.add(() -> (Item)new ItemBlock(BlockEveriteMachineFrame.block).setRegistryName(BlockEveriteMachineFrame.block.getRegistryName()));
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerModels(final ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockEveriteMachineFrame.block), 0, new ModelResourceLocation("gct_ores:everite_machine_frame", "inventory"));
    }
    
    static {
        block = null;
    }
    
    public static class BlockCustom extends Block
    {
        public BlockCustom() {
            super(Material.IRON);
            this.setTranslationKey("everite_machine_frame");
            this.setSoundType(SoundType.METAL);
            this.setHarvestLevel("pickaxe", 2);
            this.setHardness(1.5f);
            this.setResistance(20.0f);
            this.setLightLevel(0.0f);
            this.setLightOpacity(0);
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
