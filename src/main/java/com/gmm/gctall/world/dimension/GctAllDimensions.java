package com.gmm.gctall.world.dimension;

import com.gmm.gctall.client.GctAllModels;
import com.gmm.gctall.item.ItemAlfheim;
import com.gmm.gctall.item.ItemAtlantis;
import com.gmm.gctall.item.ItemDIM100;
import com.gmm.gctall.item.ItemDIM101;
import com.gmm.gctall.item.ItemDIM102;
import com.gmm.gctall.item.ItemDIMDarkerRealm;
import com.gmm.gctall.item.ItemEverheaven;
import com.gmm.gctall.item.ItemWarpedRuin;
import com.gmm.gctall.world.WorldDIM100;
import com.gmm.gctall.world.WorldDIM101;
import com.gmm.gctall.world.WorldDIM102;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public final class GctAllDimensions {
    private GctAllDimensions() {
    }

    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
                WorldDIMDarkerRealm.portal,
                WorldWarpedRuin.portal,
                WorldEverheaven.portal,
                WorldAlfheim.portal,
                WorldAtlantis.portal,
                WorldDIM100.portal,
                WorldDIM101.portal,
                WorldDIM102.portal
        );
    }

    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                new ItemBlock(WorldDIMDarkerRealm.portal).setRegistryName(WorldDIMDarkerRealm.portal.getRegistryName()),
                new ItemBlock(WorldWarpedRuin.portal).setRegistryName(WorldWarpedRuin.portal.getRegistryName()),
                new ItemBlock(WorldEverheaven.portal).setRegistryName(WorldEverheaven.portal.getRegistryName()),
                new ItemBlock(WorldAlfheim.portal).setRegistryName(WorldAlfheim.portal.getRegistryName()),
                new ItemBlock(WorldAtlantis.portal).setRegistryName(WorldAtlantis.portal.getRegistryName()),
                new ItemBlock(WorldDIM100.portal).setRegistryName(WorldDIM100.portal.getRegistryName()),
                new ItemBlock(WorldDIM101.portal).setRegistryName(WorldDIM101.portal.getRegistryName()),
                new ItemBlock(WorldDIM102.portal).setRegistryName(WorldDIM102.portal.getRegistryName()),
                ItemDIMDarkerRealm.block,
                ItemWarpedRuin.block,
                ItemEverheaven.block,
                ItemAlfheim.block,
                ItemAtlantis.block,
                ItemDIM100.block,
                ItemDIM101.block,
                ItemDIM102.block
        );
    }

    public static void registerDimensions() {
        WorldDIMDarkerRealm.registerDimension();
        WorldWarpedRuin.registerDimension();
        WorldBesideVoid.registerDimension();
        WorldEverheaven.registerDimension();
        WorldAlfheim.registerDimension();
        WorldAtlantis.registerDimension();
        WorldStarland.registerDimension();
        WorldDIM100.registerDimension();
        WorldDIM101.registerDimension();
        WorldDIM102.registerDimension();
    }

    @SideOnly(Side.CLIENT)
    public static void registerModels(ModelRegistryEvent event) {
        GctAllModels.block(WorldDIMDarkerRealm.portal);
        GctAllModels.block(WorldWarpedRuin.portal);
        GctAllModels.block(WorldEverheaven.portal);
        GctAllModels.block(WorldAlfheim.portal);
        GctAllModels.block(WorldAtlantis.portal);
        GctAllModels.block(WorldDIM100.portal);
        GctAllModels.block(WorldDIM101.portal);
        GctAllModels.block(WorldDIM102.portal);
        GctAllModels.item(ItemDIMDarkerRealm.block, "dimdarkerrealm");
        GctAllModels.item(ItemWarpedRuin.block, "warped_ruin");
        GctAllModels.item(ItemEverheaven.block, "everheaven");
        GctAllModels.item(ItemAlfheim.block, "alfheim");
        GctAllModels.item(ItemAtlantis.block, "atlantis");
        GctAllModels.item(ItemDIM100.block, "the_void");
        GctAllModels.item(ItemDIM101.block, "the_nowhere");
        GctAllModels.item(ItemDIM102.block, "orderland");
    }
}
