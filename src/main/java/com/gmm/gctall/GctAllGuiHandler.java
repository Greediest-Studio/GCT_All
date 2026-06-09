package com.gmm.gctall;

import com.gmm.gctall.gui.GuiGUISanityAltar;
import com.gmm.gctall.gui.GuiEarthbound;
import com.gmm.gctall.gui.GuiKabalahBuilder;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public final class GctAllGuiHandler implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        if (id == GuiGUISanityAltar.GUIID) {
            return new GuiGUISanityAltar.GuiContainerMod(world, x, y, z, player);
        }
        if (id == GuiKabalahBuilder.GUIID) {
            return new GuiKabalahBuilder.GuiContainerMod(world, x, y, z, player);
        }
        if (id == GuiEarthbound.GUIID) {
            return new GuiEarthbound.GuiContainerMod(world, x, y, z, player);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        if (id == GuiGUISanityAltar.GUIID) {
            return new GuiGUISanityAltar.GuiWindow(world, x, y, z, player);
        }
        if (id == GuiKabalahBuilder.GUIID) {
            return new GuiKabalahBuilder.GuiWindow(world, x, y, z, player);
        }
        if (id == GuiEarthbound.GUIID) {
            return new GuiEarthbound.GuiWindow(world, x, y, z, player);
        }
        return null;
    }
}
