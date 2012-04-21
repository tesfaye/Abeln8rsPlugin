package com.abeln8r.Abeln8rsPlugins.commands;

import com.abeln8r.Abeln8rsPlugins.Abeln8rsPlugins;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class HideCommand extends Abeln8rCommandHandler
{
    public HideCommand(Abeln8rsPlugins instance)
    {
        super(instance);
    }
    public boolean onAbeln8rCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        Player player = (Player)sender;
        pluginInstance.getLogger().info(sender.getName() + ": /" + cmd.getName());
        for(Player players: Bukkit.getOnlinePlayers())
        {
            if(players.canSee(player))
            {
                players.hidePlayer(player);
                player.sendMessage("You are now hidden");
            }else
            {
                players.showPlayer(player);
                player.sendMessage("You are now visable");
            }
        }
        return true;
    }
    public String getPermission()
    {
        return "abeln8r.perm.hide";
    }
    public boolean requiresPlayer()
    {
        return true;
    }
}