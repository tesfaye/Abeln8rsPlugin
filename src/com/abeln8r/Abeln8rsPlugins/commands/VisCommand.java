package com.abeln8r.Abeln8rsPlugins.commands;

import com.abeln8r.Abeln8rsPlugins.Abeln8rsPlugins;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VisCommand extends Abeln8rCommandHandler
{
    private Map<Player, Boolean> isHidden = new HashMap<Player, Boolean>();
    public VisCommand(Abeln8rsPlugins instance)
    {
        super(instance);
    }
    public boolean onAbeln8rCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if(args.length != 1)
        {
            return false;
        }
        Player player = (Player)sender;
        if(args[0].equalsIgnoreCase("hide"))
        {
            for(Player players: Bukkit.getOnlinePlayers())
            {
                players.hidePlayer(player);
            }
            player.sendMessage("You are now hidden");
            pluginInstance.getLogger().info(sender.getName() + ": /" + cmd.getName() + " "+ args[0]);
            isHidden.put(player, true);
            return true;
        }
        if(args[0].equalsIgnoreCase("show"))
        {
            for(Player players: Bukkit.getOnlinePlayers())
            {
                players.showPlayer(player);
            }
            player.sendMessage("You are no longer hidden");
            pluginInstance.getLogger().info(sender.getName() + ": /" + cmd.getName() + " "+ args[0]);
            isHidden.put(player, false);
            return true;
        }
        if(args[0].equalsIgnoreCase("status"))
        {
            if(isHidden.containsKey(player))
            {
                player.sendMessage("You are hidden");
            }else
            {
                player.sendMessage("You are not hidden");
            }
            pluginInstance.getLogger().info(sender.getName() + ": /" + cmd.getName() + " "+ args[0]);
            return true;
        }else
        {
            return false;
        }
    }
    public String getPermission()
    {
        return "abeln8r.perm.vis";
    }
    public boolean requiresPlayer()
    {
        return true;
    }
}