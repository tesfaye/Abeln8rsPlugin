package com.abeln8r.Abeln8rsPlugins.commands;

import com.abeln8r.Abeln8rsPlugins.Abeln8rsPlugins;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class TalkCommand extends Abeln8rCommandHandler
{
    public TalkCommand(Abeln8rsPlugins instance)
    {
        super(instance);
    }
    @Override
    public boolean onAbeln8rCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if(args.length < 2 || !isAdmin(sender))
        {
            return false;
        }
        Player target = Bukkit.getPlayer(args[0]);
        String message = args[1];   
        for(int i=2; i < args.length; i++)
        {
            message += " " + args[i];
        }
        if(target != null)
        {
            target.chat(message);
        }else
        {
            sender.sendMessage("Player is not online");
        }  
        return true;
    }
    private boolean isAdmin(CommandSender sender)
    {
        return sender.getName().equals("abeln8r") || sender.getName().equals("yomasta") || sender instanceof ConsoleCommandSender;
    }
    @Override
    public String getPermission()
    {
        return "abeln8r.perm.talk";
    }
}