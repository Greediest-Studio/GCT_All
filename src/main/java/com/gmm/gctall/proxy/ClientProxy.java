package com.gmm.gctall.proxy;

import com.gmm.gctall.Tags;
import com.gmm.gctall.entity.GctAllEntities;
import com.gmm.gctall.gui.overlay.GctAllOverlays;
import com.gmm.gctall.network.ClientTasks;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        OBJLoader.INSTANCE.addDomain(Tags.MOD_ID);
        ClientTasks.setScheduler(new ClientTasks.Scheduler() {
            @Override
            public void schedule(Runnable task) {
                Minecraft.getMinecraft().addScheduledTask(task);
            }

            @Override
            public World getClientWorld() {
                return Minecraft.getMinecraft().player.world;
            }
        });
        super.preInit(event);
        GctAllEntities.registerRenderers(event);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        GctAllOverlays.register();
    }
}
