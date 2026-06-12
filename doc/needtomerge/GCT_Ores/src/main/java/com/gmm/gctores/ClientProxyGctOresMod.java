
package com.gmm.gctores;

import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class ClientProxyGctOresMod implements IProxyGctOresMod
{
    @Override
    public void init(final FMLInitializationEvent event) {
    }
    
    @Override
    public void preInit(final FMLPreInitializationEvent event) {
        OBJLoader.INSTANCE.addDomain("gct_ores");
    }
    
    @Override
    public void postInit(final FMLPostInitializationEvent event) {
    }
    
    @Override
    public void serverLoad(final FMLServerStartingEvent event) {
    }
}
