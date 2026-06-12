
package com.gmm.gctores.block;

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
public class BlockGenite extends ElementsGctOresMod.ModElement
{
    @GameRegistry.ObjectHolder("gct_ores:genite")
    public static final Block block;
    @GameRegistry.ObjectHolder("gct_ores:genite")
    public static final Item item;
    private Fluid fluid;
    
    public BlockGenite(final ElementsGctOresMod instance) {
        super(instance, 193);
        this.fluid = new Fluid("genite", new ResourceLocation("gct_ores:blocks/genite_still"), new ResourceLocation("gct_ores:blocks/genite_flow")).setLuminosity(0).setDensity(1000).setViscosity(4000).setGaseous(false);
    }
    
    @Override
    public void initElements() {
        this.elements.blocks.add(() -> (Block)new BlockFluidClassic(this.fluid, Material.LAVA) {}.setTranslationKey("genite").setRegistryName("genite"));
        this.elements.items.add(() -> (Item)new ItemBlock(BlockGenite.block).setRegistryName("genite"));
    }
    
    @Override
    public void preInit(final FMLPreInitializationEvent event) {
        FluidRegistry.registerFluid(this.fluid);
        FluidRegistry.addBucketForFluid(this.fluid);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerModels(final ModelRegistryEvent event) {
        ModelBakery.registerItemVariants(BlockGenite.item, new ResourceLocation[0]);
        ModelLoader.setCustomMeshDefinition(BlockGenite.item, (ItemMeshDefinition)new ItemMeshDefinition() {
            public ModelResourceLocation getModelLocation(final ItemStack stack) {
                return new ModelResourceLocation("gct_ores:genite", "genite");
            }
        });
        ModelLoader.setCustomStateMapper(BlockGenite.block, (IStateMapper)new StateMapperBase() {
            protected ModelResourceLocation getModelResourceLocation(final IBlockState state) {
                return new ModelResourceLocation("gct_ores:genite", "genite");
            }
        });
    }
    
    static {
        block = null;
        item = null;
    }
}
