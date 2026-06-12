
package com.gmm.gctores;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.net.JarURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.CodeSource;
import java.util.Enumeration;
import java.util.HashSet;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.IGuiHandler;
import java.util.HashMap;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.world.storage.WorldSavedData;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraft.item.ItemStack;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.World;
import java.util.Random;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.relauncher.Side;
import java.util.Collections;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import java.util.ArrayList;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.ResourceLocation;
import java.util.Map;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraft.world.biome.Biome;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import java.util.function.Supplier;
import java.util.List;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.IFuelHandler;

public class ElementsGctOresMod implements IFuelHandler, IWorldGenerator
{
    public final List<ModElement> elements;
    public final List<Supplier<Block>> blocks;
    public final List<Supplier<Item>> items;
    public final List<Supplier<Biome>> biomes;
    public final List<Supplier<EntityEntry>> entities;
    public final List<Supplier<Potion>> potions;
    public static Map<ResourceLocation, SoundEvent> sounds;
    private int messageID;
    private boolean loaded;
    
    public ElementsGctOresMod() {
        this.elements = new ArrayList<ModElement>();
        this.blocks = new ArrayList<Supplier<Block>>();
        this.items = new ArrayList<Supplier<Item>>();
        this.biomes = new ArrayList<Supplier<Biome>>();
        this.entities = new ArrayList<Supplier<EntityEntry>>();
        this.potions = new ArrayList<Supplier<Potion>>();
        this.messageID = 0;
        this.loaded = false;
        ElementsGctOresMod.sounds.put(new ResourceLocation("gct_ores", "deepslate_break"), new SoundEvent(new ResourceLocation("gct_ores", "deepslate_break")));
        ElementsGctOresMod.sounds.put(new ResourceLocation("gct_ores", "deepslate_step"), new SoundEvent(new ResourceLocation("gct_ores", "deepslate_step")));
        ElementsGctOresMod.sounds.put(new ResourceLocation("gct_ores", "deepslate_place"), new SoundEvent(new ResourceLocation("gct_ores", "deepslate_place")));
    }
    
    public void preInit(final FMLPreInitializationEvent event) {
        this.loadElements();
        this.addNetworkMessage(GctOresModVariables.WorldSavedDataSyncMessageHandler.class, GctOresModVariables.WorldSavedDataSyncMessage.class, new Side[] { Side.SERVER, Side.CLIENT });
    }
    
    public void loadElements() {
        if (this.loaded) {
            return;
        }
        this.loaded = true;
        this.discoverElements();
        Collections.sort(this.elements);
        this.elements.forEach(ModElement::initElements);
    }
    
    private void discoverElements() {
        final Set<Class<? extends ModElement>> elementClasses = new HashSet<Class<? extends ModElement>>();
        this.findElementClassesFromCodeSource(elementClasses);
        this.findElementClassesFromClassLoader(elementClasses);
        for (final Class<? extends ModElement> clazz : elementClasses) {
            this.addElement(clazz);
        }
    }
    
    private void findElementClassesFromCodeSource(final Set<Class<? extends ModElement>> elementClasses) {
        try {
            final CodeSource codeSource = ElementsGctOresMod.class.getProtectionDomain().getCodeSource();
            if (codeSource == null) {
                return;
            }
            this.findElementClassesFromUrl(codeSource.getLocation(), elementClasses);
        }
        catch (final IOException | URISyntaxException e) {
            throw new IllegalStateException("Unable to inspect mod code source", e);
        }
    }
    
    private void findElementClassesFromClassLoader(final Set<Class<? extends ModElement>> elementClasses) {
        try {
            final ClassLoader classLoader = ElementsGctOresMod.class.getClassLoader();
            final Enumeration<URL> resources = classLoader.getResources("com/gmm/gctores");
            while (resources.hasMoreElements()) {
                final URL resource = resources.nextElement();
                this.findElementClassesFromUrl(resource, elementClasses);
            }
        }
        catch (final IOException | URISyntaxException e) {
            throw new IllegalStateException("Unable to inspect mod package", e);
        }
    }
    
    private void findElementClassesFromUrl(final URL url, final Set<Class<? extends ModElement>> elementClasses) throws IOException, URISyntaxException {
        if ("file".equals(url.getProtocol())) {
            final File file = new File(url.toURI());
            if (file.isDirectory()) {
                final File packageDirectory = file.getPath().replace('\\', '/').endsWith("com/gmm/gctores") ? file : new File(file, "com/gmm/gctores");
                final File classRoot = packageDirectory == file ? packageDirectory.getParentFile().getParentFile().getParentFile() : file;
                this.findElementClassesInDirectory(classRoot, packageDirectory, elementClasses);
            }
            else if (file.isFile() && file.getName().endsWith(".jar")) {
                this.findElementClassesInJar(file, elementClasses);
            }
        }
        else if ("jar".equals(url.getProtocol())) {
            final JarURLConnection connection = (JarURLConnection)url.openConnection();
            this.findElementClassesInJar(new File(connection.getJarFileURL().toURI()), elementClasses);
        }
    }
    
    private void findElementClassesInDirectory(final File classRoot, final File directory, final Set<Class<? extends ModElement>> elementClasses) {
        if (directory == null || !directory.isDirectory()) {
            return;
        }
        final File[] files = directory.listFiles();
        if (files == null) {
            return;
        }
        for (final File file : files) {
            if (file.isDirectory()) {
                this.findElementClassesInDirectory(classRoot, file, elementClasses);
            }
            else if (file.getName().endsWith(".class") && !file.getName().contains("$")) {
                final String className = classRoot.toURI().relativize(file.toURI()).getPath().replace('/', '.').replace(".class", "");
                this.addIfElementClass(className, elementClasses);
            }
        }
    }
    
    private void findElementClassesInJar(final File jarFile, final Set<Class<? extends ModElement>> elementClasses) {
        try (final JarFile jar = new JarFile(jarFile)) {
            final Enumeration<JarEntry> entries = jar.entries();
            while (entries.hasMoreElements()) {
                final JarEntry entry = entries.nextElement();
                final String name = entry.getName();
                if (name.startsWith("com/gmm/gctores/") && name.endsWith(".class") && !name.contains("$")) {
                    this.addIfElementClass(name.replace('/', '.').replace(".class", ""), elementClasses);
                }
            }
        }
        catch (final IOException e) {
            throw new IllegalStateException("Unable to inspect mod jar", e);
        }
    }
    
    @SuppressWarnings("unchecked")
    private void addIfElementClass(final String className, final Set<Class<? extends ModElement>> elementClasses) {
        try {
            final Class<?> clazz = Class.forName(className, false, ElementsGctOresMod.class.getClassLoader());
            if (ModElement.class.isAssignableFrom(clazz) && clazz != ModElement.class && !Modifier.isAbstract(clazz.getModifiers())) {
                elementClasses.add((Class<? extends ModElement>)clazz);
            }
        }
        catch (final ClassNotFoundException e) {
            throw new IllegalStateException("Unable to load mod element class " + className, e);
        }
    }
    
    private void addElement(final Class<? extends ModElement> clazz) {
        try {
            this.elements.add(clazz.getConstructor(ElementsGctOresMod.class).newInstance(this));
        }
        catch (final ReflectiveOperationException e) {
            throw new IllegalStateException("Unable to construct mod element " + clazz.getName(), e);
        }
    }
    
    public void registerSounds(final RegistryEvent.Register<SoundEvent> event) {
        for (final Map.Entry<ResourceLocation, SoundEvent> sound : ElementsGctOresMod.sounds.entrySet()) {
            event.getRegistry().register(sound.getValue().setRegistryName(sound.getKey()));
        }
    }
    
    public void generate(final Random random, final int chunkX, final int chunkZ, final World world, final IChunkGenerator cg, final IChunkProvider cp) {
        this.elements.forEach(element -> element.generateWorld(random, chunkX * 16, chunkZ * 16, world, world.provider.getDimension(), cg, cp));
    }
    
    public int getBurnTime(final ItemStack fuel) {
        for (final ModElement element : this.elements) {
            final int ret = element.addFuel(fuel);
            if (ret != 0) {
                return ret;
            }
        }
        return 0;
    }
    
    @SubscribeEvent
    public void onPlayerLoggedIn(final PlayerEvent.PlayerLoggedInEvent event) {
        if (!event.player.world.isRemote) {
            final WorldSavedData mapdata = GctOresModVariables.MapVariables.get(event.player.world);
            final WorldSavedData worlddata = GctOresModVariables.WorldVariables.get(event.player.world);
            if (mapdata != null) {
                GctOresMod.PACKET_HANDLER.sendTo((IMessage)new GctOresModVariables.WorldSavedDataSyncMessage(0, mapdata), (EntityPlayerMP)event.player);
            }
            if (worlddata != null) {
                GctOresMod.PACKET_HANDLER.sendTo((IMessage)new GctOresModVariables.WorldSavedDataSyncMessage(1, worlddata), (EntityPlayerMP)event.player);
            }
        }
    }
    
    @SubscribeEvent
    public void onPlayerChangedDimension(final PlayerEvent.PlayerChangedDimensionEvent event) {
        if (!event.player.world.isRemote) {
            final WorldSavedData worlddata = GctOresModVariables.WorldVariables.get(event.player.world);
            if (worlddata != null) {
                GctOresMod.PACKET_HANDLER.sendTo((IMessage)new GctOresModVariables.WorldSavedDataSyncMessage(1, worlddata), (EntityPlayerMP)event.player);
            }
        }
    }
    
    public <T extends IMessage, V extends IMessage> void addNetworkMessage(final Class<? extends IMessageHandler<T, V>> handler, final Class<T> messageClass, final Side... sides) {
        for (final Side side : sides) {
            GctOresMod.PACKET_HANDLER.registerMessage((Class)handler, (Class)messageClass, this.messageID, side);
        }
        ++this.messageID;
    }
    
    public List<ModElement> getElements() {
        return this.elements;
    }
    
    public List<Supplier<Block>> getBlocks() {
        return this.blocks;
    }
    
    public List<Supplier<Item>> getItems() {
        return this.items;
    }
    
    public List<Supplier<Biome>> getBiomes() {
        return this.biomes;
    }
    
    public List<Supplier<EntityEntry>> getEntities() {
        return this.entities;
    }
    
    public List<Supplier<Potion>> getPotions() {
        return this.potions;
    }
    
    static {
        ElementsGctOresMod.sounds = new HashMap<ResourceLocation, SoundEvent>();
    }
    
    public static class GuiHandler implements IGuiHandler
    {
        public Object getServerGuiElement(final int id, final EntityPlayer player, final World world, final int x, final int y, final int z) {
            return null;
        }
        
        public Object getClientGuiElement(final int id, final EntityPlayer player, final World world, final int x, final int y, final int z) {
            return null;
        }
    }
    
    public static class ModElement implements Comparable<ModElement>
    {
        protected final ElementsGctOresMod elements;
        protected final int sortid;
        
        public ModElement(final ElementsGctOresMod elements, final int sortid) {
            this.elements = elements;
            this.sortid = sortid;
        }
        
        public void initElements() {
        }
        
        public void init(final FMLInitializationEvent event) {
        }
        
        public void preInit(final FMLPreInitializationEvent event) {
        }
        
        public void generateWorld(final Random random, final int posX, final int posZ, final World world, final int dimID, final IChunkGenerator cg, final IChunkProvider cp) {
        }
        
        public void serverLoad(final FMLServerStartingEvent event) {
        }
        
        public void registerModels(final ModelRegistryEvent event) {
        }
        
        public int addFuel(final ItemStack fuel) {
            return 0;
        }
        
        @Override
        public int compareTo(final ModElement other) {
            return this.sortid - other.sortid;
        }
        
        @Retention(RetentionPolicy.RUNTIME)
        public @interface Tag {
        }
    }
}
