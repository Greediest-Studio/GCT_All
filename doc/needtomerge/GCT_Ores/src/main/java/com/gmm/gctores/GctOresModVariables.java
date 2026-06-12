
package com.gmm.gctores;

import net.minecraftforge.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraft.world.World;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.storage.WorldSavedData;

public class GctOresModVariables
{
    public static class MapVariables extends WorldSavedData
    {
        public static final String DATA_NAME = "gct_ores_mapvars";
        
        public MapVariables() {
            super("gct_ores_mapvars");
        }
        
        public MapVariables(final String s) {
            super(s);
        }
        
        public void readFromNBT(final NBTTagCompound nbt) {
        }
        
        public NBTTagCompound writeToNBT(final NBTTagCompound nbt) {
            return nbt;
        }
        
        public void syncData(final World world) {
            this.markDirty();
            if (world.isRemote) {
                GctOresMod.PACKET_HANDLER.sendToServer((IMessage)new WorldSavedDataSyncMessage(0, this));
            }
            else {
                GctOresMod.PACKET_HANDLER.sendToAll((IMessage)new WorldSavedDataSyncMessage(0, this));
            }
        }
        
        public static MapVariables get(final World world) {
            MapVariables instance = (MapVariables)world.getMapStorage().getOrLoadData((Class)MapVariables.class, "gct_ores_mapvars");
            if (instance == null) {
                instance = new MapVariables();
                world.getMapStorage().setData("gct_ores_mapvars", (WorldSavedData)instance);
            }
            return instance;
        }
    }
    
    public static class WorldVariables extends WorldSavedData
    {
        public static final String DATA_NAME = "gct_ores_worldvars";
        
        public WorldVariables() {
            super("gct_ores_worldvars");
        }
        
        public WorldVariables(final String s) {
            super(s);
        }
        
        public void readFromNBT(final NBTTagCompound nbt) {
        }
        
        public NBTTagCompound writeToNBT(final NBTTagCompound nbt) {
            return nbt;
        }
        
        public void syncData(final World world) {
            this.markDirty();
            if (world.isRemote) {
                GctOresMod.PACKET_HANDLER.sendToServer((IMessage)new WorldSavedDataSyncMessage(1, this));
            }
            else {
                GctOresMod.PACKET_HANDLER.sendToDimension((IMessage)new WorldSavedDataSyncMessage(1, this), world.provider.getDimension());
            }
        }
        
        public static WorldVariables get(final World world) {
            WorldVariables instance = (WorldVariables)world.getPerWorldStorage().getOrLoadData((Class)WorldVariables.class, "gct_ores_worldvars");
            if (instance == null) {
                instance = new WorldVariables();
                world.getPerWorldStorage().setData("gct_ores_worldvars", (WorldSavedData)instance);
            }
            return instance;
        }
    }
    
    public static class WorldSavedDataSyncMessageHandler implements IMessageHandler<WorldSavedDataSyncMessage, IMessage>
    {
        public IMessage onMessage(final WorldSavedDataSyncMessage message, final MessageContext context) {
            if (context.side == Side.SERVER) {
                context.getServerHandler().player.getServerWorld().addScheduledTask(() -> this.syncData(message, context, context.getServerHandler().player.world));
            }
            else {
                Minecraft.getMinecraft().addScheduledTask(() -> this.syncData(message, context, Minecraft.getMinecraft().player.world));
            }
            return null;
        }
        
        private void syncData(final WorldSavedDataSyncMessage message, final MessageContext context, final World world) {
            if (context.side == Side.SERVER) {
                message.data.markDirty();
                if (message.type == 0) {
                    GctOresMod.PACKET_HANDLER.sendToAll((IMessage)message);
                }
                else {
                    GctOresMod.PACKET_HANDLER.sendToDimension((IMessage)message, world.provider.getDimension());
                }
            }
            if (message.type == 0) {
                world.getMapStorage().setData("gct_ores_mapvars", message.data);
            }
            else {
                world.getPerWorldStorage().setData("gct_ores_worldvars", message.data);
            }
        }
    }
    
    public static class WorldSavedDataSyncMessage implements IMessage
    {
        public int type;
        public WorldSavedData data;
        
        public WorldSavedDataSyncMessage() {
        }
        
        public WorldSavedDataSyncMessage(final int type, final WorldSavedData data) {
            this.type = type;
            this.data = data;
        }
        
        public void toBytes(final ByteBuf buf) {
            buf.writeInt(this.type);
            ByteBufUtils.writeTag(buf, this.data.writeToNBT(new NBTTagCompound()));
        }
        
        public void fromBytes(final ByteBuf buf) {
            this.type = buf.readInt();
            if (this.type == 0) {
                this.data = new MapVariables();
            }
            else {
                this.data = new WorldVariables();
            }
            this.data.readFromNBT(ByteBufUtils.readTag(buf));
        }
    }
}
