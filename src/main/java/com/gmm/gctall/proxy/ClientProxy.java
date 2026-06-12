package com.gmm.gctall.proxy;

import com.gmm.gctall.Tags;
import com.gmm.gctall.common.network.ClientTasks;
import com.gmm.gctall.misc.registry.GctAllClientLifecycle;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        ClientTasks.setScheduler(new MinecraftClientScheduler());
        super.preInit(event);
        GctAllClientLifecycle.preInit(event, Tags.MOD_ID);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        GctAllClientLifecycle.init(event);
    }

}
