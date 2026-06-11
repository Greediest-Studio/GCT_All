package com.gmm.gctall.gui.overlay;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public final class GctAllOverlays {
    private GctAllOverlays() {
    }

    @SideOnly(Side.CLIENT)
    public static void register() {
        MinecraftForge.EVENT_BUS.register(new OverlaySanityRender.SanityOverlayRenderer());
        MinecraftForge.EVENT_BUS.register(new OverlayBlueScreenOverlay.BlueScreenOverlayRenderer());
    }
}
