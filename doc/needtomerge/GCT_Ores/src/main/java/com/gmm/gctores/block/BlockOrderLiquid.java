
package com.gmm.gctores.block;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.WorldGenLakes;
import com.gmm.gctores.world.WorldDIM102;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.World;
import java.util.Random;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class BlockOrderLiquid extends ElementsGctOresMod.ModElement
{
    @GameRegistry.ObjectHolder("gct_ores:order_liquid")
    public static final Block block;
    @GameRegistry.ObjectHolder("gct_ores:order_liquid")
    public static final Item item;
    private Fluid fluid;
    
    public BlockOrderLiquid(final ElementsGctOresMod instance) {
        super(instance, 487);
        this.fluid = new Fluid("order_liquid", new ResourceLocation("gct_ores:blocks/order_liquid"), new ResourceLocation("gct_ores:blocks/order_liquid")).setLuminosity(0).setDensity(1000).setViscosity(1000).setGaseous(false);
    }
    
    @Override
    public void initElements() {
        this.elements.blocks.add(() -> (Block)new BlockFluidClassic(this.fluid, Material.WATER) {}.setTranslationKey("order_liquid").setRegistryName("order_liquid"));
        this.elements.items.add(() -> (Item)new ItemBlock(BlockOrderLiquid.block).setRegistryName("order_liquid"));
    }
    
    @Override
    public void preInit(final FMLPreInitializationEvent event) {
        FluidRegistry.registerFluid(this.fluid);
        FluidRegistry.addBucketForFluid(this.fluid);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerModels(final ModelRegistryEvent event) {
        ModelBakery.registerItemVariants(BlockOrderLiquid.item, new ResourceLocation[0]);
        ModelLoader.setCustomMeshDefinition(BlockOrderLiquid.item, (ItemMeshDefinition)new ItemMeshDefinition() {
            public ModelResourceLocation getModelLocation(final ItemStack stack) {
                return new ModelResourceLocation("gct_ores:order_liquid", "order_liquid");
            }
        });
        ModelLoader.setCustomStateMapper(BlockOrderLiquid.block, (IStateMapper)new StateMapperBase() {
            protected ModelResourceLocation getModelResourceLocation(final IBlockState state) {
                return new ModelResourceLocation("gct_ores:order_liquid", "order_liquid");
            }
        });
    }
    
    @Override
    public void generateWorld(final Random random, final int chunkX, final int chunkZ, final World world, final int dimID, final IChunkGenerator cg, final IChunkProvider cp) {
        boolean dimensionCriteria = false;
        if (dimID == WorldDIM102.DIMID) {
            dimensionCriteria = true;
        }
        if (!dimensionCriteria) {
            return;
        }
        final int i = chunkX + random.nextInt(16) + 8;
        final int j = random.nextInt(256);
        final int k = chunkZ + random.nextInt(16) + 8;
        new WorldGenLakes(BlockOrderLiquid.block).generate(world, random, new BlockPos(i, j, k));
    }
    
    static {
        block = null;
        item = null;
    }
}
