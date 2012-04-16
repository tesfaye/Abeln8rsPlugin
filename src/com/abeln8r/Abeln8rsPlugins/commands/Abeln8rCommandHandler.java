package com.abeln8r.Abeln8rsPlugins.commands;

import com.abeln8r.Abeln8rsPlugins.Abeln8rsPlugins;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class Abeln8rCommandHandler implements CommandExecutor 
{
    public Abeln8rCommandHandler(Abeln8rsPlugins plugininstance)
    {
        pluginInstance = plugininstance;
    }
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if(requiresPlayer() && !(sender instanceof Player))
        {
            sender.sendMessage("Sorry, only Players can use such commands!");
            return true;
        }else
        {
            return onAbeln8rCommand(sender, cmd, commandLabel, args);
        }
    }
    public boolean requiresPlayer()
    {
        return false;
    }
    public abstract String getPermissions();
    public abstract boolean onAbeln8rCommand(CommandSender sender, Command cmd, String commandLabel, String[] args);
    protected Abeln8rsPlugins pluginInstance;
}