package com.gmm.gctall.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.procedure.ProcedureProGamemode0;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Tag
public class CommandGamemode0 extends GctAllElement {
  public CommandGamemode0(GctAllContent instance) {
    super(instance, 386);
  }
  
  public void serverLoad(FMLServerStartingEvent event) {
    event.registerServerCommand(new CommandHandler());
  }
  
  public static class CommandHandler implements ICommand {
    public int compareTo(ICommand c) {
      return getName().compareTo(c.getName());
    }
    
    public boolean checkPermission(MinecraftServer server, ICommandSender var1) {
      return true;
    }
    
    public List getAliases() {
      return new ArrayList();
    }
    
    public List getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos pos) {
      return new ArrayList();
    }
    
    public boolean isUsernameIndex(String[] string, int index) {
      return true;
    }
    
    public String getName() {
      return "gm 0";
    }
    
    public String getUsage(ICommandSender var1) {
      return "/gm 0 [<arguments>]";
    }
    
    public void execute(MinecraftServer server, ICommandSender sender, String[] cmd) {
      int x = sender.getPosition().getX();
      int y = sender.getPosition().getY();
      int z = sender.getPosition().getZ();
      Entity entity = sender.getCommandSenderEntity();
      if (entity != null) {
        World world = entity.world;
        HashMap<String, String> cmdparams = new HashMap<>();
        int[] index = { 0 };
        Arrays.<String>stream(cmd).forEach(param -> {
              cmdparams.put(Integer.toString(index[0]), param);
              index[0] = index[0] + 1;
            });
        Map<String, Object> $_dependencies = new HashMap<>();
        $_dependencies.put("entity", entity);
        ProcedureProGamemode0.executeProcedure($_dependencies);
      } 
    }
  }
}

