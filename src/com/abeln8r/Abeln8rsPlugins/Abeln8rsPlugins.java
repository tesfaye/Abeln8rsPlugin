package com.abeln8r.Abeln8rsPlugins;

import com.abeln8r.Abeln8rsPlugins.commands.TalkCommand;
import com.abeln8r.Abeln8rsPlugins.commands.VisCommand;
import com.abeln8r.Abeln8rsPlugins.event.Abeln8rBlockListener;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Abeln8rsPlugins extends JavaPlugin
{
    public Map<Player, Boolean> isHidden = new HashMap<Player, Boolean>();
    public void onEnable()
    {
        getCommand("tk").setExecutor(new TalkCommand(this));
        getCommand("vis").setExecutor(new VisCommand(this));
        PluginManager pm = getServer().getPluginManager();
        //TODO pm.registerEvents(new Abeln8rBlockListener(this), this);
    }
    public void onDisable()
    {
        
    }
}