package com.gmm.gctall.client;

import com.gmm.gctall.Tags;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public final class GctAllModels {
    private GctAllModels() {
    }

    public static void item(Item item, String registryName) {
        ModelLoader.setCustomModelResourceLocation(item, 0,
                new ModelResourceLocation(Tags.MOD_ID + ":" + registryName, "inventory"));
    }

    public static void block(Block block) {
        Item item = Item.getItemFromBlock(block);
        if (item == Items.AIR || block.getRegistryName() == null) {
            return;
        }
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
    }

}
