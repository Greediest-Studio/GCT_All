package com.gmm.gctall.client;

import com.gmm.gctall.Tags;
import com.gmm.gctall.registry.GctAllContent;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = Tags.MOD_ID, value = Side.CLIENT)
public final class GctAllModels {
    private GctAllModels() {
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        GctAllContent.registerModels(event);
    }

    public static void item(Item item, String registryName) {
        ModelLoader.setCustomModelResourceLocation(item, 0,
                new ModelResourceLocation(Tags.MOD_ID + ":" + registryName, "inventory"));
    }

    public static void block(Block block) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
                new ModelResourceLocation(block.getRegistryName(), "inventory"));
    }

}
