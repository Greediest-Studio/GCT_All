
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
import com.gmm.gctores.procedure.ProcedureTonitruiumPush;
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
public class BlockTonitruium extends ElementsGctOresMod.ModElement
{
    @GameRegistry.ObjectHolder("gct_ores:tonitruium")
    public static final Block block;
    @GameRegistry.ObjectHolder("gct_ores:tonitruium")
    public static final Item item;
    private Fluid fluid;
    
    public BlockTonitruium(final ElementsGctOresMod instance) {
        super(instance, 197);
        this.fluid = new Fluid("tonitruium", new ResourceLocation("gct_ores:blocks/frightened_tonitruium_still"), new ResourceLocation("gct_ores:blocks/frightened_tonitruium_flow")).setLuminosity(9).setDensity(980).setViscosity(3500).setGaseous(false);
    }
    
    @Override
    public void initElements() {
        this.elements.blocks.add(() -> (Block)new BlockFluidClassic(this.fluid, Material.LAVA) {
            public void onEntityCollision(final World world, final BlockPos pos, final IBlockState state, final Entity entity) {
                super.onEntityCollision(world, pos, state, entity);
                final int x = pos.getX();
                final int y = pos.getY();
                final int z = pos.getZ();
                final Map $_dependencies = new HashMap();
                $_dependencies.put("entity", entity);
                $_dependencies.put("world", world);
                ProcedureTonitruiumPush.executeProcedure($_dependencies);
            }
        }.setTranslationKey("tonitruium").setRegistryName("tonitruium"));
        this.elements.items.add(() -> (Item)new ItemBlock(BlockTonitruium.block).setRegistryName("tonitruium"));
    }
    
    @Override
    public void preInit(final FMLPreInitializationEvent event) {
        FluidRegistry.registerFluid(this.fluid);
        FluidRegistry.addBucketForFluid(this.fluid);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerModels(final ModelRegistryEvent event) {
        ModelBakery.registerItemVariants(BlockTonitruium.item, new ResourceLocation[0]);
        ModelLoader.setCustomMeshDefinition(BlockTonitruium.item, (ItemMeshDefinition)new ItemMeshDefinition() {
            public ModelResourceLocation getModelLocation(final ItemStack stack) {
                return new ModelResourceLocation("gct_ores:tonitruium", "tonitruium");
            }
        });
        ModelLoader.setCustomStateMapper(BlockTonitruium.block, (IStateMapper)new StateMapperBase() {
            protected ModelResourceLocation getModelResourceLocation(final IBlockState state) {
                return new ModelResourceLocation("gct_ores:tonitruium", "tonitruium");
            }
        });
    }
    
    static {
        block = null;
        item = null;
    }
}
