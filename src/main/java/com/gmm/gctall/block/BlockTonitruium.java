package com.gmm.gctall.block;

import com.gmm.gctall.client.GctAllFluidModels;
import com.gmm.gctall.procedure.ProcedureTonitruiumPush;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockTonitruium extends BlockFluidClassic {
    private static final Fluid FLUID = registerFluid();

    public static final Block block = new BlockTonitruium();
    public static final Item item = new ItemBlock(block);

    public BlockTonitruium() {
        super(FLUID, Material.LAVA);
        setTranslationKey("tonitruium");
    }

    public static void preInit(FMLPreInitializationEvent event) {
        FluidRegistry.addBucketForFluid(FLUID);
    }

    private static Fluid registerFluid() {
        Fluid fluid = new Fluid("tonitruium",
                new ResourceLocation("gct_all:blocks/frightened_tonitruium_still"),
                new ResourceLocation("gct_all:blocks/frightened_tonitruium_flow"))
                .setLuminosity(9)
                .setDensity(980)
                .setViscosity(3500)
                .setGaseous(false);
        return FluidRegistry.registerFluid(fluid) ? fluid : FluidRegistry.getFluid(fluid.getName());
    }

    @Override
    public void onEntityCollision(World world, BlockPos pos, IBlockState state, Entity entity) {
        super.onEntityCollision(world, pos, state, entity);
        Map<String, Object> dependencies = new HashMap<>();
        dependencies.put("entity", entity);
        dependencies.put("world", world);
        ProcedureTonitruiumPush.executeProcedure(dependencies);
    }

    @SideOnly(Side.CLIENT)
    public static void registerModels(ModelRegistryEvent event) {
        GctAllFluidModels.register(block, item, "tonitruium");
    }
}
