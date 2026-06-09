package com.gmm.gctall.proxy;

import com.gmm.gctall.GctAllGuiHandler;
import com.gmm.gctall.GctAllMod;
import com.gmm.gctall.world.gen.ModOreWorldGenerator;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllOreDictionary;
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
        GameRegistry.registerWorldGenerator(GctAllContent.INSTANCE, 5);
        GameRegistry.registerWorldGenerator(new ModOreWorldGenerator(), 5);
        GameRegistry.registerFuelHandler(GctAllContent.INSTANCE);
        NetworkRegistry.INSTANCE.registerGuiHandler(GctAllMod.INSTANCE, new GctAllGuiHandler());

        GctAllContent.INSTANCE.preInit(event);
        MinecraftForge.EVENT_BUS.register(GctAllContent.INSTANCE);
        GctAllContent.INSTANCE.getElements().forEach(element -> element.preInit(event));
    }

    public void init(FMLInitializationEvent event) {
        GctAllOreDictionary.register();
        GctAllContent.INSTANCE.getElements().forEach(element -> element.init(event));
    }

    public void postInit(FMLPostInitializationEvent event) {
    }

    public void serverLoad(FMLServerStartingEvent event) {
        GctAllContent.INSTANCE.getElements().forEach(element -> element.serverLoad(event));
    }
}
