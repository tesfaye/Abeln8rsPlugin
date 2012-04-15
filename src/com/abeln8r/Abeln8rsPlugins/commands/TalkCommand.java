package com.abeln8r.Abeln8rsPlugins.commands;

import com.abeln8r.Abeln8rsPlugins.Abeln8rsPlugins;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TalkCommand extends Abeln8rCommandHandler
{
    public TalkCommand(Abeln8rsPlugins instance)
    {
        super(instance);
    }
    public boolean requiresPlayer()
    {
        return false;
    }
    public boolean onAbeln8rCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if(args.length < 2)
        {
            return false;
        }
        Player target = Bukkit.getPlayer(args[0]);
        String message = args[1];   
        if(target != null)
        {
            String s;
            if(target.isOp())
            {
                String pname = ChatColor.DARK_RED + target.getDisplayName();
                s = "["+target.getWorld().getName()+"]<" + pname + ChatColor.WHITE + "> " + message;
                Bukkit.getServer().broadcastMessage(s);
            }else
            {
                s = "["+target.getWorld().getName()+"]<" + target.getDisplayName() + "> " + message;
                Bukkit.getServer().broadcastMessage(s);
            }
        }else
        {
            Bukkit.getServer().broadcastMessage("[world]<" + args[0] + "> " + message);
        }  
        pluginInstance.getLogger().info(sender.getName() + ": /" + cmd.getName() + " "+ args[0] + " " + args[1]);
        return true;
    }
}