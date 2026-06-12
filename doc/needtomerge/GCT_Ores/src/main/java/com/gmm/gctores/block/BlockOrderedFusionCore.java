
package com.gmm.gctores.block;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.client.util.ITooltipFlag;
import java.util.List;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import com.gmm.gctores.creativetab.TabCTabWitheric;
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
public class BlockOrderedFusionCore extends ElementsGctOresMod.ModElement
{
    @GameRegistry.ObjectHolder("gct_ores:ordered_fusion_core")
    public static final Block block;
    
    public BlockOrderedFusionCore(final ElementsGctOresMod instance) {
        super(instance, 94);
    }
    
    @Override
    public void initElements() {
        this.elements.blocks.add(() -> (Block)new BlockCustom().setRegistryName("ordered_fusion_core"));
        this.elements.items.add(() -> (Item)new ItemBlock(BlockOrderedFusionCore.block).setRegistryName(BlockOrderedFusionCore.block.getRegistryName()));
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerModels(final ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockOrderedFusionCore.block), 0, new ModelResourceLocation("gct_ores:ordered_fusion_core", "inventory"));
    }
    
    static {
        block = null;
    }
    
    public static class BlockCustom extends Block
    {
        public BlockCustom() {
            super(Material.ROCK);
            this.setTranslationKey("ordered_fusion_core");
            this.setSoundType(SoundType.STONE);
            this.setHarvestLevel("pickaxe", 13);
            this.setHardness(50.0f);
            this.setResistance(200000.0f);
            this.setLightLevel(1.0f);
            this.setLightOpacity(0);
            this.setCreativeTab(TabCTabWitheric.tab);
        }
        
        public void addInformation(final ItemStack itemstack, final World world, final List<String> list, final ITooltipFlag flag) {
            super.addInformation(itemstack, world, (List)list, flag);
            list.add("\u7528\u5b83\u6765\u805a\u5408\u79e9\u5e8f\u4e4b\u7269\uff01");
        }
        
        @SideOnly(Side.CLIENT)
        public BlockRenderLayer getRenderLayer() {
            return BlockRenderLayer.CUTOUT;
        }
        
        public boolean isOpaqueCube(final IBlockState state) {
            return false;
        }
        
        public boolean canConnectRedstone(final IBlockState state, final IBlockAccess world, final BlockPos pos, final EnumFacing side) {
            return true;
        }
    }
}
