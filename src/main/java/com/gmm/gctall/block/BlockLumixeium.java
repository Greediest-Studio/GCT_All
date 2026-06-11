package com.gmm.gctall.block;

import com.gmm.gctall.client.GctAllFluidModels;
import com.gmm.gctall.procedure.ProcedureLumixeiumPush;
import com.gmm.gctall.procedure.ProcedureLumixeiumTick;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
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

public class BlockLumixeium extends BlockFluidClassic {
    private static final Fluid FLUID = registerFluid();

    public static final Block block = new BlockLumixeium();
    public static final Item item = new ItemBlock(block);

    public BlockLumixeium() {
        super(FLUID, Material.WATER);
        setTranslationKey("lumixeium");
    }

    public static void preInit(FMLPreInitializationEvent event) {
        FluidRegistry.addBucketForFluid(FLUID);
    }

    private static Fluid registerFluid() {
        Fluid fluid = new Fluid("lumixeium",
                new ResourceLocation("gct_all:blocks/scared_lumixeium_still"),
                new ResourceLocation("gct_all:blocks/scared_lumixeium_flow"))
                .setLuminosity(15)
                .setDensity(950)
                .setViscosity(500)
                .setGaseous(true);
        return FluidRegistry.registerFluid(fluid) ? fluid : FluidRegistry.getFluid(fluid.getName());
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random random) {
        super.updateTick(world, pos, state, random);
        Map<String, Object> dependencies = new HashMap<>();
        dependencies.put("x", pos.getX());
        dependencies.put("y", pos.getY());
        dependencies.put("z", pos.getZ());
        dependencies.put("world", world);
        ProcedureLumixeiumTick.executeProcedure(dependencies);
        world.scheduleUpdate(pos, this, tickRate(world));
    }

    @Override
    public void onEntityCollision(World world, BlockPos pos, IBlockState state, Entity entity) {
        super.onEntityCollision(world, pos, state, entity);
        Map<String, Object> dependencies = new HashMap<>();
        dependencies.put("entity", entity);
        ProcedureLumixeiumPush.executeProcedure(dependencies);
    }

    @SideOnly(Side.CLIENT)
    public static void registerModels(ModelRegistryEvent event) {
        GctAllFluidModels.register(block, item, "lumixeium");
    }
}
