package com.gmm.gctall.common.items.crafting;

import com.gmm.gctall.common.blocks.BlockManaCobbleStone;
import com.gmm.gctall.common.blocks.BlockManaStone;
import com.gmm.gctall.common.blocks.BlockOrderCobblestone;
import com.gmm.gctall.common.blocks.BlockOrderStone;
import com.gmm.gctall.common.blocks.BlockOrderStoneBrick;
import com.gmm.gctall.common.blocks.BlockOrderStoneBrickCrashed;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class GctAllRecipes {
    private GctAllRecipes() {
    }

    public static void registerSmelting() {
        GameRegistry.addSmelting(new ItemStack(BlockManaCobbleStone.block), new ItemStack(BlockManaStone.block), 0.0F);
        GameRegistry.addSmelting(new ItemStack(BlockOrderCobblestone.block), new ItemStack(BlockOrderStone.block), 1.0F);
        GameRegistry.addSmelting(new ItemStack(BlockOrderStoneBrick.block), new ItemStack(BlockOrderStoneBrickCrashed.block), 1.0F);
    }
}
