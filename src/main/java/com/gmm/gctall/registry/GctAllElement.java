package com.gmm.gctall.registry;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Random;
import java.util.function.Supplier;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionType;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;

public abstract class GctAllElement implements Comparable<GctAllElement> {
    protected final GctAllContent elements;
    protected final int sortid;

    protected GctAllElement(GctAllContent elements, int sortid) {
        this.elements = elements;
        this.sortid = sortid;
    }

    public void initElements() {
    }

    public void preInit(FMLPreInitializationEvent event) {
    }

    public void init(FMLInitializationEvent event) {
    }

    public void serverLoad(FMLServerStartingEvent event) {
    }

    public void generateWorld(Random random, int posX, int posZ, World world, int dimID,
            IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
    }

    public void registerModels(ModelRegistryEvent event) {
    }

    public int addFuel(ItemStack fuel) {
        return 0;
    }

    protected void registerBlockWithItem(Supplier<? extends Block> blockFactory, String registryName) {
        final Block[] registeredBlock = new Block[1];
        registerBlock(() -> {
            Block block = blockFactory.get();
            block.setRegistryName(registryName);
            registeredBlock[0] = block;
            return block;
        });
        registerItem(() -> {
            Block block = registeredBlock[0];
            if (block == null) {
                throw new IllegalStateException("Block " + registryName + " was not registered before its item.");
            }
            ItemBlock item = new ItemBlock(block);
            item.setRegistryName(block.getRegistryName());
            return item;
        }, registryName);
    }

    protected void registerItem(Supplier<? extends Item> itemFactory) {
        elements.getItems().add(() -> itemFactory.get());
    }

    protected void registerItem(Supplier<? extends Item> itemFactory, String modelName) {
        final Item[] registeredItem = new Item[1];
        elements.getItems().add(() -> {
            Item item = itemFactory.get();
            registeredItem[0] = item;
            return item;
        });
        elements.getItemModels().add(new GctAllContent.ItemModel(() -> {
            if (registeredItem[0] == null) {
                throw new IllegalStateException("Item " + modelName + " was not registered before its model.");
            }
            return registeredItem[0];
        }, modelName));
    }

    protected void registerBlock(Supplier<? extends Block> blockFactory) {
        elements.getBlocks().add(() -> blockFactory.get());
    }

    protected void registerBlockItem(Block[] blockHolder, String registryName) {
        registerItem(() -> {
            Block block = blockHolder[0];
            if (block == null) {
                throw new IllegalStateException("Block " + registryName + " was not registered before its item.");
            }
            return new ItemBlock(block).setRegistryName(registryName);
        });
    }

    protected void registerBlockItem(Supplier<? extends Item> itemFactory) {
        registerItem(itemFactory);
    }

    protected void registerBiome(Supplier<? extends Biome> biomeFactory) {
        elements.getBiomes().add(() -> biomeFactory.get());
    }

    protected void registerEntity(Supplier<? extends EntityEntry> entityFactory) {
        elements.getEntities().add(() -> entityFactory.get());
    }

    protected void registerPotion(Supplier<? extends Potion> potionFactory) {
        elements.getPotions().add(() -> potionFactory.get());
    }

    protected void registerPotionType(Supplier<? extends PotionType> potionTypeFactory) {
        elements.getPotionTypes().add(() -> potionTypeFactory.get());
    }

    @Override
    public int compareTo(GctAllElement other) {
        return Integer.compare(this.sortid, other.sortid);
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface Tag {
    }
}
