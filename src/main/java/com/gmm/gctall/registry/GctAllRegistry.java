package com.gmm.gctall.registry;

import com.gmm.gctall.Tags;
import java.util.function.Supplier;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;

@Mod.EventBusSubscriber(modid = Tags.MOD_ID)
public final class GctAllRegistry {
    private GctAllRegistry() {
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        registerAll(event, GctAllContent.INSTANCE.getBlocks());
        com.gmm.gctall.registry.GctBasesBlocks.registerBlocks(event.getRegistry());
        com.gmm.gctall.registry.GctMacBlocks.registerBlocks(event);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        registerAll(event, GctAllContent.INSTANCE.getItems());
        com.gmm.gctall.registry.GctBasesBlocks.registerItems(event.getRegistry());
        com.gmm.gctall.registry.GctMacBlocks.registerItems(event);
    }

    @SubscribeEvent
    public static void registerBiomes(RegistryEvent.Register<Biome> event) {
        registerAll(event, GctAllContent.INSTANCE.getBiomes());
    }

    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityEntry> event) {
        registerAll(event, GctAllContent.INSTANCE.getEntities());
    }

    @SubscribeEvent
    public static void registerPotions(RegistryEvent.Register<Potion> event) {
        registerAll(event, GctAllContent.INSTANCE.getPotions());
    }

    @SubscribeEvent
    public static void registerPotionTypes(RegistryEvent.Register<PotionType> event) {
        registerAll(event, GctAllContent.INSTANCE.getPotionTypes());
    }

    @SubscribeEvent
    public static void registerSounds(RegistryEvent.Register<SoundEvent> event) {
        GctAllContent.INSTANCE.registerSounds(event);
    }

    private static <T extends net.minecraftforge.registries.IForgeRegistryEntry<T>> void registerAll(
            RegistryEvent.Register<T> event,
            Iterable<Supplier<T>> entries
    ) {
        for (Supplier<T> entry : entries) {
            event.getRegistry().register(normalizeRegistryName(entry.get()));
        }
    }

    private static <T extends net.minecraftforge.registries.IForgeRegistryEntry<T>> T normalizeRegistryName(T entry) {
        ResourceLocation name = entry.getRegistryName();
        if (name == null) {
            throw new IllegalStateException("Missing registry name for " + entry.getClass().getName());
        }
        if ("minecraft".equals(name.getNamespace())) {
            entry.setRegistryName(new ResourceLocation(Tags.MOD_ID, name.getPath()));
        }
        return entry;
    }
}
