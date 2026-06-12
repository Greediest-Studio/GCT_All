
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
import com.gmm.gctores.procedure.ProcedureLumixeiumPush;
import net.minecraft.entity.Entity;
import java.util.Map;
import com.gmm.gctores.procedure.ProcedureLumixeiumTick;
import java.util.HashMap;
import java.util.Random;
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
public class BlockLumixeium extends ElementsGctOresMod.ModElement
{
    @GameRegistry.ObjectHolder("gct_ores:lumixeium")
    public static final Block block;
    @GameRegistry.ObjectHolder("gct_ores:lumixeium")
    public static final Item item;
    private Fluid fluid;
    
    public BlockLumixeium(final ElementsGctOresMod instance) {
        super(instance, 195);
        this.fluid = new Fluid("lumixeium", new ResourceLocation("gct_ores:blocks/scared_lumixeium_still"), new ResourceLocation("gct_ores:blocks/scared_lumixeium_flow")).setLuminosity(15).setDensity(950).setViscosity(500).setGaseous(true);
    }
    
    @Override
    public void initElements() {
        this.elements.blocks.add(() -> (Block)new BlockFluidClassic(this.fluid, Material.WATER) {
            public void updateTick(final World world, final BlockPos pos, final IBlockState state, final Random random) {
                super.updateTick(world, pos, state, random);
                final int x = pos.getX();
                final int y = pos.getY();
                final int z = pos.getZ();
                final Map $_dependencies = new HashMap();
                $_dependencies.put("x", x);
                $_dependencies.put("y", y);
                $_dependencies.put("z", z);
                $_dependencies.put("world", world);
                ProcedureLumixeiumTick.executeProcedure($_dependencies);
                world.scheduleUpdate(new BlockPos(x, y, z), (Block)this, this.tickRate(world));
            }
            
            public void onEntityCollision(final World world, final BlockPos pos, final IBlockState state, final Entity entity) {
                super.onEntityCollision(world, pos, state, entity);
                final int x = pos.getX();
                final int y = pos.getY();
                final int z = pos.getZ();
                final Map $_dependencies = new HashMap();
                $_dependencies.put("entity", entity);
                ProcedureLumixeiumPush.executeProcedure($_dependencies);
            }
        }.setTranslationKey("lumixeium").setRegistryName("lumixeium"));
        this.elements.items.add(() -> (Item)new ItemBlock(BlockLumixeium.block).setRegistryName("lumixeium"));
    }
    
    @Override
    public void preInit(final FMLPreInitializationEvent event) {
        FluidRegistry.registerFluid(this.fluid);
        FluidRegistry.addBucketForFluid(this.fluid);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerModels(final ModelRegistryEvent event) {
        ModelBakery.registerItemVariants(BlockLumixeium.item, new ResourceLocation[0]);
        ModelLoader.setCustomMeshDefinition(BlockLumixeium.item, (ItemMeshDefinition)new ItemMeshDefinition() {
            public ModelResourceLocation getModelLocation(final ItemStack stack) {
                return new ModelResourceLocation("gct_ores:lumixeium", "lumixeium");
            }
        });
        ModelLoader.setCustomStateMapper(BlockLumixeium.block, (IStateMapper)new StateMapperBase() {
            protected ModelResourceLocation getModelResourceLocation(final IBlockState state) {
                return new ModelResourceLocation("gct_ores:lumixeium", "lumixeium");
            }
        });
    }
    
    static {
        block = null;
        item = null;
    }
}
