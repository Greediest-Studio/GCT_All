package com.gmm.gctall.block;

import com.gmm.gctall.client.GctAllFluidModels;
import com.gmm.gctall.world.WorldDIM102;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockOrderLiquid extends BlockFluidClassic {
    private static final Fluid FLUID = registerFluid();

    public static final Block block = new BlockOrderLiquid();
    public static final Item item = new ItemBlock(block);

    public BlockOrderLiquid() {
        super(FLUID, Material.WATER);
        setTranslationKey("order_liquid");
    }

    public static void preInit(FMLPreInitializationEvent event) {
        FluidRegistry.addBucketForFluid(FLUID);
    }

    private static Fluid registerFluid() {
        Fluid fluid = new Fluid("order_liquid",
                new ResourceLocation("gct_all:blocks/order_liquid"),
                new ResourceLocation("gct_all:blocks/order_liquid"))
                .setLuminosity(0)
                .setDensity(1000)
                .setViscosity(1000)
                .setGaseous(false);
        return FluidRegistry.registerFluid(fluid) ? fluid : FluidRegistry.getFluid(fluid.getName());
    }

    public static void generateWorld(Random random, int chunkX, int chunkZ, World world, int dimID,
            IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if (dimID != WorldDIM102.DIMID) {
            return;
        }
        int x = chunkX + random.nextInt(16) + 8;
        int y = random.nextInt(256);
        int z = chunkZ + random.nextInt(16) + 8;
        new WorldGenLakes(block).generate(world, random, new BlockPos(x, y, z));
    }

    @SideOnly(Side.CLIENT)
    public static void registerModels(ModelRegistryEvent event) {
        GctAllFluidModels.register(block, item, "order_liquid");
    }
}
