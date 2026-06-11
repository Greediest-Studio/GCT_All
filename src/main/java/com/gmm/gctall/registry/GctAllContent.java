package com.gmm.gctall.registry;

import com.gmm.gctall.block.GctAllBlocks;
import com.gmm.gctall.client.GctAllModels;
import com.gmm.gctall.item.GctAllItems;
import com.gmm.gctall.world.dimension.GctAllDimensions;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public final class GctAllContent {
    private GctAllContent() {
    }

    public static void preInit(FMLPreInitializationEvent event) {
        GctAllBlocks.preInit(event);
    }

    public static void init(FMLInitializationEvent event) {
        GctAllBlocks.init(event);
    }

    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        GctAllBlocks.registerBlocks(event);
        GctAllDimensions.registerBlocks(event);
        GctBasesBlocks.registerBlocks(event.getRegistry());
        GctMacBlocks.registerBlocks(event);
    }

    public static void registerItems(RegistryEvent.Register<Item> event) {
        GctAllBlocks.registerItems(event);
        GctAllItems.registerItems(event);
        GctAllDimensions.registerItems(event);
        GctBasesBlocks.registerItems(event.getRegistry());
        GctMacBlocks.registerItems(event);
    }

    @SideOnly(Side.CLIENT)
    public static void registerModels(ModelRegistryEvent event) {
        GctAllBlocks.registerModels(event);
        GctAllItems.registerModels();
        GctAllDimensions.registerModels(event);

        for (Block ore : GctBasesBlocks.getOres()) {
            GctAllModels.block(ore);
        }

        GctMacBlocks.registerModels(event);
    }
}
