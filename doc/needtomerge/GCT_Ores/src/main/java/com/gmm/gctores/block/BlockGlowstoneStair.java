
package com.gmm.gctores.block;

import net.minecraft.init.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import com.gmm.gctores.creativetab.TabCTabBuilding;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.BlockStairs;
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
public class BlockGlowstoneStair extends ElementsGctOresMod.ModElement
{
    @GameRegistry.ObjectHolder("gct_ores:glowstone_stair")
    public static final Block block;
    
    public BlockGlowstoneStair(final ElementsGctOresMod instance) {
        super(instance, 172);
    }
    
    @Override
    public void initElements() {
        this.elements.blocks.add(() -> (Block)new BlockCustom().setRegistryName("glowstone_stair"));
        this.elements.items.add(() -> (Item)new ItemBlock(BlockGlowstoneStair.block).setRegistryName(BlockGlowstoneStair.block.getRegistryName()));
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerModels(final ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockGlowstoneStair.block), 0, new ModelResourceLocation("gct_ores:glowstone_stair", "inventory"));
    }
    
    static {
        block = null;
    }
    
    public static class BlockCustom extends BlockStairs
    {
        public BlockCustom() {
            super(new Block(Material.GLASS).getDefaultState());
            this.setTranslationKey("glowstone_stair");
            this.setSoundType(SoundType.GLASS);
            this.setHardness(1.0f);
            this.setResistance(10.0f);
            this.setLightLevel(1.0f);
            this.setLightOpacity(0);
            this.setCreativeTab(TabCTabBuilding.tab);
        }
        
        @SideOnly(Side.CLIENT)
        public BlockRenderLayer getRenderLayer() {
            return BlockRenderLayer.CUTOUT;
        }
        
        public boolean isOpaqueCube(final IBlockState state) {
            return false;
        }
        
        public void getDrops(final NonNullList<ItemStack> drops, final IBlockAccess world, final BlockPos pos, final IBlockState state, final int fortune) {
            drops.add(new ItemStack(Items.GLOWSTONE_DUST, 5));
        }
    }
}
