package com.gmm.gctall.registry;

import com.gmm.gctall.common.GctAllCreativeTab;

import com.gmm.gctall.block.MachineBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;

public final class GctMacBlocks {
    public static final String MODEL_ATOMIC_VIBERATOR = "model_atomic_viberator";
    public static final String MODEL_ATOMIC_DECAYER = "model_atomic_decayer";
    public static final String MODEL_ATOMIC_ACIDOR = "model_atomic_acidor";
    public static final String MODEL_ENDER_FORGE = "model_ender_forge";

    public static final Block ATOMIC_VIBERATOR = machine(MODEL_ATOMIC_VIBERATOR,
            "\u00A77\u5C06\u4E2D\u5B50\u6CE8\u5165\u77FF\u7269\u3002");
    public static final Block ATOMIC_DECAYER = machine(MODEL_ATOMIC_DECAYER,
            "\u00A77\u52A0\u901F\u653E\u5C04\u7269\u7684\u8870\u53D8\u3002");
    public static final Block ATOMIC_ACIDOR = machine(MODEL_ATOMIC_ACIDOR,
            "\u00A77\u4F7F\u7528\u6C1F\u738B\u6C34\u6EB6\u89E3\u91D1\u5C5E\u3002");
    public static final Block ENDER_FORGE = new MachineBlock(MODEL_ENDER_FORGE, SoundType.GROUND, 1.0F, 10.0F,
            GctAllCreativeTab.TAB, null);

    private GctMacBlocks() {
    }

    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
                ATOMIC_VIBERATOR,
                ATOMIC_DECAYER,
                ATOMIC_ACIDOR,
                ENDER_FORGE);
    }

    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                itemBlock(ATOMIC_VIBERATOR),
                itemBlock(ATOMIC_DECAYER),
                itemBlock(ATOMIC_ACIDOR),
                itemBlock(ENDER_FORGE));
    }

    private static ItemBlock itemBlock(Block block) {
        return (ItemBlock) new ItemBlock(block).setRegistryName(block.getRegistryName());
    }

    private static Block machine(String name, String tooltip) {
        Block block = new MachineBlock(name, SoundType.STONE, 5.0F, 10.0F, GctAllCreativeTab.TAB, tooltip);
        block.setHarvestLevel("pickaxe", 1);
        return block;
    }
}

