package com.gmm.gctall.common.blocks;

import com.gmm.gctall.client.GctAllFluidModels;
import com.gmm.gctall.common.events.LumixeiumPush;
import com.gmm.gctall.common.events.LumixeiumTick;
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
      LumixeiumTick.run(world, pos.getX(), pos.getY(), pos.getZ());
        world.scheduleUpdate(pos, this, tickRate(world));
    }

    @Override
    public void onEntityCollision(World world, BlockPos pos, IBlockState state, Entity entity) {
        super.onEntityCollision(world, pos, state, entity);
      LumixeiumPush.run(entity);
    }

    @SideOnly(Side.CLIENT)
    public static void registerModels(ModelRegistryEvent event) {
        GctAllFluidModels.register(block, item, "lumixeium");
    }
}
