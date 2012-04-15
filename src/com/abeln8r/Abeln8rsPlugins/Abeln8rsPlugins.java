package com.abeln8r.Abeln8rsPlugins;

import java.util.logging.Level;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class Abeln8rsPlugins extends JavaPlugin
{
    
    public void onEnable()
    {
    }
 
    public void onDisable()
    {
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
        if(cmd.getName().equalsIgnoreCase("tk"))
        {
            if(args.length < 2 || !hasAdminAccess(sender))
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
                getLogger().log(Level.INFO, "{0}: {1}", new Object[]{target.getDisplayName(), commandLabel});
                return true;
           }else
           {
                Bukkit.getServer().broadcastMessage("[world]<" + args[0] + "> " + message);
                getLogger().log(Level.INFO, "{0}: {1}", new Object[]{args[0], commandLabel});
                return true;
           }  
        }
        return false;
    }
    private boolean hasAdminAccess(CommandSender sender)
    {
        return sender.getName().equalsIgnoreCase("abeln8r") || sender.getName().equalsIgnoreCase("yomasta");
    }
}