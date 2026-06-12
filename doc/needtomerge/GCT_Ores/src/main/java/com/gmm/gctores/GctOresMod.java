
package com.gmm.gctores;

import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.Mod;

@Mod(modid = "gct_ores", version = "1.0.0")
public class GctOresMod
{
    public static final String MODID = "gct_ores";
    public static final String VERSION = "1.0.0";
    public static final ElementsGctOresMod ELEMENTS;
    public static final SimpleNetworkWrapper PACKET_HANDLER;
    @SidedProxy(clientSide = "com.gmm.gctores.ClientProxyGctOresMod", serverSide = "com.gmm.gctores.ServerProxyGctOresMod")
    public static IProxyGctOresMod proxy;
    @Mod.Instance("gct_ores")
    public static GctOresMod instance;
    public ElementsGctOresMod elements;
    
    public GctOresMod() {
        this.elements = GctOresMod.ELEMENTS;
    }
    
    @Mod.EventHandler
    public void preInit(final FMLPreInitializationEvent event) {
        GameRegistry.registerWorldGenerator((IWorldGenerator)this.elements, 5);
        GameRegistry.registerFuelHandler((IFuelHandler)this.elements);
        NetworkRegistry.INSTANCE.registerGuiHandler((Object)this, (IGuiHandler)new ElementsGctOresMod.GuiHandler());
        this.elements.preInit(event);
        MinecraftForge.EVENT_BUS.register((Object)this.elements);
        this.elements.getElements().forEach(element -> element.preInit(event));
        GctOresMod.proxy.preInit(event);
    }
    
    @Mod.EventHandler
    public void init(final FMLInitializationEvent event) {
        this.elements.getElements().forEach(element -> element.init(event));
        GctOresMod.proxy.init(event);
    }
    
    @Mod.EventHandler
    public void postInit(final FMLPostInitializationEvent event) {
        GctOresMod.proxy.postInit(event);
    }
    
    @Mod.EventHandler
    public void serverLoad(final FMLServerStartingEvent event) {
        this.elements.getElements().forEach(element -> element.serverLoad(event));
        GctOresMod.proxy.serverLoad(event);
    }
    
    static {
        ELEMENTS = new ElementsGctOresMod();
        PACKET_HANDLER = NetworkRegistry.INSTANCE.newSimpleChannel("gct_ores:a");
        FluidRegistry.enableUniversalBucket();
    }
}
