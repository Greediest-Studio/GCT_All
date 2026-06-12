
package com.gmm.gctores.block;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
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
import java.util.Map;
import com.gmm.gctores.procedure.ProcedureNoxexeumPush;
import java.util.HashMap;
import net.minecraft.entity.Entity;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import com.gmm.gctores.ElementsGctOresMod.ModElement;
import com.gmm.gctores.ElementsGctOresMod;
public class BlockNoxexeum extends ElementsGctOresMod.ModElement
{
    @GameRegistry.ObjectHolder("gct_ores:noxexeum")
    public static final Block block;
    @GameRegistry.ObjectHolder("gct_ores:noxexeum")
    public static final Item item;
    private Fluid fluid;
    
    public BlockNoxexeum(final ElementsGctOresMod instance) {
        super(instance, 196);
        this.fluid = new Fluid("noxexeum", new ResourceLocation("gct_ores:blocks/deepest_noxexeum_still"), new ResourceLocation("gct_ores:blocks/deepest_noxexeum_flow")).setLuminosity(0).setDensity(2560).setViscosity(5000).setGaseous(false);
    }
    
    @Override
    public void initElements() {
        this.elements.blocks.add(() -> (Block)new BlockFluidClassic(this.fluid, Material.WATER) {
            public void onEntityCollision(final World world, final BlockPos pos, final IBlockState state, final Entity entity) {
                super.onEntityCollision(world, pos, state, entity);
                final int x = pos.getX();
                final int y = pos.getY();
                final int z = pos.getZ();
                final Map $_dependencies = new HashMap();
                $_dependencies.put("entity", entity);
                ProcedureNoxexeumPush.executeProcedure($_dependencies);
            }
        }.setTranslationKey("noxexeum").setRegistryName("noxexeum"));
        this.elements.items.add(() -> (Item)new ItemBlock(BlockNoxexeum.block).setRegistryName("noxexeum"));
    }
    
    @Override
    public void preInit(final FMLPreInitializationEvent event) {
        FluidRegistry.registerFluid(this.fluid);
        FluidRegistry.addBucketForFluid(this.fluid);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerModels(final ModelRegistryEvent event) {
        ModelBakery.registerItemVariants(BlockNoxexeum.item, new ResourceLocation[0]);
        ModelLoader.setCustomMeshDefinition(BlockNoxexeum.item, (ItemMeshDefinition)new ItemMeshDefinition() {
            public ModelResourceLocation getModelLocation(final ItemStack stack) {
                return new ModelResourceLocation("gct_ores:noxexeum", "noxexeum");
            }
        });
        ModelLoader.setCustomStateMapper(BlockNoxexeum.block, (IStateMapper)new StateMapperBase() {
            protected ModelResourceLocation getModelResourceLocation(final IBlockState state) {
                return new ModelResourceLocation("gct_ores:noxexeum", "noxexeum");
            }
        });
    }
    
    static {
        block = null;
        item = null;
    }
}
