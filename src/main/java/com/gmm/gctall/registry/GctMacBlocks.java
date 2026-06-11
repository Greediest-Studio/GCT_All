package com.gmm.gctall.registry;

import com.gmm.gctall.common.GctAllCreativeTab;

import com.gmm.gctall.block.MachineBlock;
import com.gmm.gctall.client.GctAllModels;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public final class GctMacBlocks {
    public static final String MODEL_ATOMIC_VIBERATOR = "model_atomic_viberator";
    public static final String MODEL_ATOMIC_DECAYER = "model_atomic_decayer";
    public static final String MODEL_ATOMIC_ACIDOR = "model_atomic_acidor";
    public static final String MODEL_ENDER_FORGE = "model_ender_forge";

    public static final Block ATOMIC_VIBERATOR = machine(MODEL_ATOMIC_VIBERATOR,
            "§7将中子注入矿物。");
    public static final Block ATOMIC_DECAYER = machine(MODEL_ATOMIC_DECAYER,
            "§7加速放射物的衰变。");
    public static final Block ATOMIC_ACIDOR = machine(MODEL_ATOMIC_ACIDOR,
            "§7使用氟王水溶解金属。");
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

    @SideOnly(Side.CLIENT)
    public static void registerModels(ModelRegistryEvent event) {
        GctAllModels.block(ATOMIC_VIBERATOR);
        GctAllModels.block(ATOMIC_DECAYER);
        GctAllModels.block(ATOMIC_ACIDOR);
        GctAllModels.block(ENDER_FORGE);
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

