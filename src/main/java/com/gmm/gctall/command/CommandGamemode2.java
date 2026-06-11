package com.gmm.gctall.command;

import com.gmm.gctall.procedure.ProcedureProGamemode2;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;

public class CommandGamemode2 implements ICommand {
    @Override
    public int compareTo(ICommand command) {
        return getName().compareTo(command.getName());
    }

    @Override
    public String getName() {
        return "gm2";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/gm2";
    }

    @Override
    public List<String> getAliases() {
        return Collections.emptyList();
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) {
        Entity entity = sender.getCommandSenderEntity();
        if (entity == null) {
            return;
        }

        Map<String, Object> dependencies = new HashMap<>();
        dependencies.put("entity", entity);
        ProcedureProGamemode2.executeProcedure(dependencies);
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos pos) {
        return Collections.emptyList();
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return false;
    }
}