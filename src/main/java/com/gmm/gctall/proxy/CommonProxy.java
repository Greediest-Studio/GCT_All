package com.gmm.gctall.proxy;

import com.gmm.gctall.command.GctAllCommands;
import com.gmm.gctall.GctAllGuiHandler;
import com.gmm.gctall.GctAllMod;
import com.gmm.gctall.data.GctAllVariableEvents;
import com.gmm.gctall.entity.GctAllEntities;
import com.gmm.gctall.gui.GctAllGuiNetwork;
import com.gmm.gctall.item.crafting.GctAllRecipes;
import com.gmm.gctall.network.GctAllMessages;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllOreDictionary;
import com.gmm.gctall.world.biome.GctAllBiomes;
import com.gmm.gctall.world.dimension.GctAllDimensions;
import com.gmm.gctall.world.structure.GctAllStructureGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
    static {
        FluidRegistry.enableUniversalBucket();
    }

    public void preInit(FMLPreInitializationEvent event) {
        GameRegistry.registerWorldGenerator(new GctAllStructureGenerator(), 5);
        NetworkRegistry.INSTANCE.registerGuiHandler(GctAllMod.INSTANCE, new GctAllGuiHandler());

        GctAllContent.preInit(event);
        GctAllDimensions.registerDimensions();
        GctAllMessages.register();
        GctAllGuiNetwork.registerMessages();
        MinecraftForge.EVENT_BUS.register(new GctAllVariableEvents());
    }

    public void init(FMLInitializationEvent event) {
        GctAllBiomes.init();
        GctAllOreDictionary.register();
        GctAllRecipes.registerSmelting();
        GctAllContent.init(event);
        GctAllEntities.init(event);
    }

    public void postInit(FMLPostInitializationEvent event) {
    }

    public void serverLoad(FMLServerStartingEvent event) {
        GctAllCommands.register(event);
    }
}
