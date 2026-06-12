package com.gmm.gctall.common.network;

import com.gmm.gctall.Tags;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public final class GctAllNetwork {
    public static final SimpleNetworkWrapper CHANNEL = NetworkRegistry.INSTANCE.newSimpleChannel(Tags.MOD_ID);

    private static int discriminator;

    private GctAllNetwork() {
    }

    public static <T extends IMessage, V extends IMessage> void register(
            Class<? extends IMessageHandler<T, V>> handler,
            Class<T> message,
            Side... sides
    ) {
        for (Side side : sides) {
            CHANNEL.registerMessage(handler, message, discriminator++, side);
        }
    }
}
