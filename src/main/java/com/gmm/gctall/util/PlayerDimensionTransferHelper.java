package com.gmm.gctall.util;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.Teleporter;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

public final class PlayerDimensionTransferHelper {
    private PlayerDimensionTransferHelper() {
    }

    public static void transfer(EntityPlayerMP player, int dimension, Teleporter teleporter) {
        ReflectionHelper.setPrivateValue(EntityPlayerMP.class, player, true,
                "invulnerableDimensionChange", "invulnerableDimensionChange");
        player.server.getPlayerList().transferPlayerToDimension(player, dimension, teleporter);
    }
}
