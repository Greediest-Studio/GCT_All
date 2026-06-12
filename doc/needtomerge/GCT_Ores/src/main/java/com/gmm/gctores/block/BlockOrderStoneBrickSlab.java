
package com.gmm.gctores.block;

import net.minecraft.util.IStringSerializable;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import com.gmm.gctores.creativetab.TabCTabBuilding;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraft.item.ItemSlab;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class BlockOrderStoneBrickSlab extends ElementsGctOresMod.ModElement
{
    @GameRegistry.ObjectHolder("gct_ores:order_stone_brick_slab")
    public static final Block block;
    @GameRegistry.ObjectHolder("gct_ores:order_stone_brick_slab_double")
    public static final Block block_slab_double;
    
    public BlockOrderStoneBrickSlab(final ElementsGctOresMod instance) {
        super(instance, 165);
    }
    
    @Override
    public void initElements() {
        this.elements.blocks.add(() -> (Block)new BlockCustom().setRegistryName("order_stone_brick_slab"));
        this.elements.blocks.add(() -> (Block)new BlockCustom.Double().setRegistryName("order_stone_brick_slab_double"));
        this.elements.items.add(() -> (Item)new ItemSlab(BlockOrderStoneBrickSlab.block, (BlockSlab)BlockOrderStoneBrickSlab.block, (BlockSlab)BlockOrderStoneBrickSlab.block_slab_double).setRegistryName(BlockOrderStoneBrickSlab.block.getRegistryName()));
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerModels(final ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockOrderStoneBrickSlab.block), 0, new ModelResourceLocation("gct_ores:order_stone_brick_slab", "inventory"));
    }
    
    static {
        block = null;
        block_slab_double = null;
    }
    
    public static class BlockCustom extends BlockSlab
    {
        public static final PropertyEnum<Variant> VARIANT;
        
        public BlockCustom() {
            super(Material.ROCK);
            this.setTranslationKey("order_stone_brick_slab");
            this.setSoundType(SoundType.STONE);
            this.setHarvestLevel("pickaxe", 12);
            this.setHardness(50.0f);
            this.setResistance(4000.0f);
            this.setLightLevel(0.0f);
            this.setLightOpacity(15);
            this.setCreativeTab(TabCTabBuilding.tab);
            IBlockState state = this.blockState.getBaseState().withProperty((IProperty)BlockCustom.VARIANT, (Comparable)Variant.DEFAULT);
            if (!this.isDouble()) {
                state = state.withProperty((IProperty)BlockSlab.HALF, (Comparable)BlockSlab.EnumBlockHalf.BOTTOM);
            }
            this.setDefaultState(state);
            this.useNeighborBrightness = !this.isDouble();
        }
        
        public Item getItemDropped(final IBlockState state, final Random rand, final int fortune) {
            return Item.getItemFromBlock(BlockOrderStoneBrickSlab.block);
        }
        
        public ItemStack getItem(final World worldIn, final BlockPos pos, final IBlockState state) {
            return new ItemStack(BlockOrderStoneBrickSlab.block);
        }
        
        protected BlockStateContainer createBlockState() {
            return this.isDouble() ? new BlockStateContainer((Block)this, new IProperty[] { (IProperty)BlockCustom.VARIANT }) : new BlockStateContainer((Block)this, new IProperty[] { (IProperty)BlockCustom.HALF, (IProperty)BlockCustom.VARIANT });
        }
        
        public IBlockState getStateFromMeta(final int meta) {
            if (this.isDouble()) {
                return this.getDefaultState();
            }
            return this.getDefaultState().withProperty((IProperty)BlockCustom.HALF, (Comparable)BlockSlab.EnumBlockHalf.values()[meta % 2]);
        }
        
        public int getMetaFromState(final IBlockState state) {
            if (this.isDouble()) {
                return 0;
            }
            return ((BlockSlab.EnumBlockHalf)state.getValue((IProperty)BlockCustom.HALF)).ordinal();
        }
        
        public String getTranslationKey(final int meta) {
            return super.getTranslationKey();
        }
        
        public IProperty<?> getVariantProperty() {
            return (IProperty<?>)BlockCustom.VARIANT;
        }
        
        public Comparable<?> getTypeForItem(final ItemStack stack) {
            return Variant.DEFAULT;
        }
        
        public boolean isDouble() {
            return false;
        }
        
        public boolean doesSideBlockRendering(final IBlockState state, final IBlockAccess world, final BlockPos pos, final EnumFacing face) {
            return this.isDouble() || super.doesSideBlockRendering(state, world, pos, face);
        }
        
        @SideOnly(Side.CLIENT)
        public BlockRenderLayer getRenderLayer() {
            return BlockRenderLayer.CUTOUT;
        }
        
        public boolean isOpaqueCube(final IBlockState state) {
            return false;
        }
        
        static {
            VARIANT = PropertyEnum.create("variant", (Class)Variant.class);
        }
        
        public enum Variant implements IStringSerializable
        {
            DEFAULT;
            
            public String getName() {
                return "default";
            }
        }
        
        public static class Double extends BlockCustom
        {
            @Override
            public boolean isDouble() {
                return true;
            }
        }
    }
}
