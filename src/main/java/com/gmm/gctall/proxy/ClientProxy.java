package com.gmm.gctall.proxy;

import com.gmm.gctall.Tags;
import com.gmm.gctall.network.ClientTasks;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraftforge.client.model.obj.OBJLoader;
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
    }
}
