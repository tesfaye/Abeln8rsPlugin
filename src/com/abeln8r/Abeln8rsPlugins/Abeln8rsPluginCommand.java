package com.abeln8r.Abeln8rsPlugins;

import java.util.logging.Level;
import org.bukkit.command.CommandExecutor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Abeln8rsPluginCommand implements CommandExecutor
{
    private Abeln8rsPlugins plugin;
    public Abeln8rsPluginCommand(Abeln8rsPlugins plugin)
    {
        this.plugin = plugin;        
    }
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        Player player = null;
	if(sender instanceof Player) 
	{
		player = (Player)sender;
	}
        if(player == null) 
	{
            sender.sendMessage("Sorry, only Players can use such commands!");
            return true;
        }else
        if(args[0].equals("tk"))
        {
            if(args.length != 3)
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
           plugin.getLogger().log(Level.INFO, "{0}: {1}", new Object[]{player.getName(), commandLabel});
           return true;
        }
        return false;
    }
}