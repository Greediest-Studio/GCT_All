package com.gmm.gctall.misc.registry;

import com.gmm.gctall.GctAllGuiHandler;
import com.gmm.gctall.GctAllMod;
import com.gmm.gctall.common.commands.GctAllCommands;
import com.gmm.gctall.common.data.GctAllVariableEvents;
import com.gmm.gctall.common.entity.GctAllEntities;
import com.gmm.gctall.client.gui.GctAllGuiNetwork;
import com.gmm.gctall.common.items.crafting.GctAllRecipes;
import com.gmm.gctall.common.network.GctAllMessages;
import com.gmm.gctall.common.world.biome.GctAllBiomes;
import com.gmm.gctall.common.world.dimension.GctAllDimensions;
import com.gmm.gctall.common.world.structure.GctAllStructureGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class GctAllLifecycle {
    private GctAllLifecycle() {
    }

    public static void preInit(FMLPreInitializationEvent event) {
        GameRegistry.registerWorldGenerator(new GctAllStructureGenerator(), 5);
        NetworkRegistry.INSTANCE.registerGuiHandler(GctAllMod.INSTANCE, new GctAllGuiHandler());

        GctAllContent.preInit(event);
        GctAllTileEntities.register();
        GctAllDimensions.registerDimensions();
        GctAllMessages.register();
        GctAllGuiNetwork.registerMessages();
        MinecraftForge.EVENT_BUS.register(new GctAllVariableEvents());
    }

    public static void init(FMLInitializationEvent event) {
        GctAllBiomes.init();
        GctAllOreDictionary.register();
        GctAllRecipes.registerSmelting();
        GctAllEntities.init(event);
    }

    public static void serverLoad(FMLServerStartingEvent event) {
        GctAllCommands.register(event);
    }
}
