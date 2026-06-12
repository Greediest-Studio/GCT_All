package com.gmm.gctall.common.world.dimension;

import com.gmm.gctall.client.GctAllModels;
import com.gmm.gctall.misc.GctAllCreativeTab;
import com.gmm.gctall.common.items.PortalActivatorItem;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public final class GctAllDimensions {
    private static final Block[] PORTALS = {
            WorldDarkerRealm.portal,
            WorldWarpedRuin.portal,
            WorldEverheaven.portal,
            WorldAlfheim.portal,
            WorldAtlantis.portal,
            WorldTheVoid.portal,
            WorldTheNowhere.portal,
            WorldOrderland.portal
    };

    public static final Item DIM_DARKER_REALM = new PortalActivatorItem("dimdarkerrealm", GctAllCreativeTab.TAB,
            WorldDarkerRealm.portal, WorldDarkerRealm.portal::portalSpawn);
    public static final Item WARPED_RUIN = new PortalActivatorItem("warped_ruin", GctAllCreativeTab.TAB,
            WorldWarpedRuin.portal, WorldWarpedRuin.portal::portalSpawn);
    public static final Item EVERHEAVEN = new PortalActivatorItem("everheaven", GctAllCreativeTab.TAB,
            WorldEverheaven.portal, WorldEverheaven.portal::portalSpawn);
    public static final Item ALFHEIM = new PortalActivatorItem("alfheim", GctAllCreativeTab.TAB,
            WorldAlfheim.portal, WorldAlfheim.portal::portalSpawn);
    public static final Item ATLANTIS = new PortalActivatorItem("atlantis", GctAllCreativeTab.TAB,
            WorldAtlantis.portal, WorldAtlantis.portal::portalSpawn);
    public static final Item THE_VOID = new PortalActivatorItem("the_void", GctAllCreativeTab.TAB,
            WorldTheVoid.portal, WorldTheVoid.portal::portalSpawn);
    public static final Item THE_NOWHERE = new PortalActivatorItem("the_nowhere", GctAllCreativeTab.TAB,
            WorldTheNowhere.portal, WorldTheNowhere.portal::portalSpawn);
    public static final Item ORDERLAND = new PortalActivatorItem("orderland", GctAllCreativeTab.TAB,
            WorldOrderland.portal, WorldOrderland.portal::portalSpawn);

    private GctAllDimensions() {
    }

    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(PORTALS);
    }

    public static void registerItems(RegistryEvent.Register<Item> event) {
        for (Block portal : PORTALS) {
            event.getRegistry().register(new ItemBlock(portal).setRegistryName(portal.getRegistryName()));
        }

        event.getRegistry().registerAll(
                DIM_DARKER_REALM,
                WARPED_RUIN,
                EVERHEAVEN,
                ALFHEIM,
                ATLANTIS,
                THE_VOID,
                THE_NOWHERE,
                ORDERLAND
        );
    }

    public static void registerDimensions() {
        WorldDarkerRealm.registerDimension();
        WorldWarpedRuin.registerDimension();
        WorldBesideVoid.registerDimension();
        WorldEverheaven.registerDimension();
        WorldAlfheim.registerDimension();
        WorldAtlantis.registerDimension();
        WorldStarland.registerDimension();
        WorldTheVoid.registerDimension();
        WorldTheNowhere.registerDimension();
        WorldOrderland.registerDimension();
    }

    @SideOnly(Side.CLIENT)
    public static void registerModels(ModelRegistryEvent event) {
        for (Block portal : PORTALS) {
            GctAllModels.block(portal);
        }

        GctAllModels.item(DIM_DARKER_REALM, "dimdarkerrealm");
        GctAllModels.item(WARPED_RUIN, "warped_ruin");
        GctAllModels.item(EVERHEAVEN, "everheaven");
        GctAllModels.item(ALFHEIM, "alfheim");
        GctAllModels.item(ATLANTIS, "atlantis");
        GctAllModels.item(THE_VOID, "the_void");
        GctAllModels.item(THE_NOWHERE, "the_nowhere");
        GctAllModels.item(ORDERLAND, "orderland");
    }
}
