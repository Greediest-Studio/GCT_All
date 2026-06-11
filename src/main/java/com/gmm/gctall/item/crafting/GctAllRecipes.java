package com.gmm.gctall.item.crafting;

import com.gmm.gctall.block.BlockManaCobbleStone;
import com.gmm.gctall.block.BlockManaStone;
import com.gmm.gctall.block.BlockOrderCobblestone;
import com.gmm.gctall.block.BlockOrderStone;
import com.gmm.gctall.block.BlockOrderStoneBrick;
import com.gmm.gctall.block.BlockOrderStoneBrickCrashed;
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
