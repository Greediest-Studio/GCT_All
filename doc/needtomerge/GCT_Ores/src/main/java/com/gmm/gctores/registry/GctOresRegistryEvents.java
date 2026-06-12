package com.gmm.gctores.registry;

import java.util.function.Supplier;

import com.gmm.gctores.ElementsGctOresMod;
import com.gmm.gctores.GctOresMod;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(modid = GctOresMod.MODID)
public final class GctOresRegistryEvents
{
    private GctOresRegistryEvents() {
    }
    
    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event) {
        final ElementsGctOresMod elements = GctOresMod.ELEMENTS;
        elements.loadElements();
        event.getRegistry().registerAll(elements.getBlocks().stream().map(Supplier::get).toArray(Block[]::new));
    }
    
    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        final ElementsGctOresMod elements = GctOresMod.ELEMENTS;
        elements.loadElements();
        event.getRegistry().registerAll(elements.getItems().stream().map(Supplier::get).toArray(Item[]::new));
    }
    
    @SubscribeEvent
    public static void registerBiomes(final RegistryEvent.Register<Biome> event) {
        final ElementsGctOresMod elements = GctOresMod.ELEMENTS;
        elements.loadElements();
        event.getRegistry().registerAll(elements.getBiomes().stream().map(Supplier::get).toArray(Biome[]::new));
    }
    
    @SubscribeEvent
    public static void registerEntities(final RegistryEvent.Register<EntityEntry> event) {
        final ElementsGctOresMod elements = GctOresMod.ELEMENTS;
        elements.loadElements();
        event.getRegistry().registerAll(elements.getEntities().stream().map(Supplier::get).toArray(EntityEntry[]::new));
    }
    
    @SubscribeEvent
    public static void registerPotions(final RegistryEvent.Register<Potion> event) {
        final ElementsGctOresMod elements = GctOresMod.ELEMENTS;
        elements.loadElements();
        event.getRegistry().registerAll(elements.getPotions().stream().map(Supplier::get).toArray(Potion[]::new));
    }
    
    @SubscribeEvent
    public static void registerSounds(final RegistryEvent.Register<SoundEvent> event) {
        GctOresMod.ELEMENTS.registerSounds(event);
    }
    
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void registerModels(final ModelRegistryEvent event) {
        final ElementsGctOresMod elements = GctOresMod.ELEMENTS;
        elements.loadElements();
        elements.getElements().forEach(element -> element.registerModels(event));
    }
}
