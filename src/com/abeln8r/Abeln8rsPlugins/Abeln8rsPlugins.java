package com.abeln8r.Abeln8rsPlugins;

import com.abeln8r.Abeln8rsPlugins.commands.*;
import com.abeln8r.Abeln8rsPlugins.event.Abeln8rBlockListener;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Abeln8rsPlugins extends JavaPlugin
{
    public Map<Player, Boolean> isHidden = new HashMap<Player, Boolean>();
    @Override
    public void onEnable()
    {
        getCommand("tk").setExecutor(new TalkCommand(this));
        getCommand("vis").setExecutor(new VisCommand(this));
        getCommand("ecry").setExecutor(new ECRYCommand(this));
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new Abeln8rBlockListener(this), this);
    }
    @Override
    public void onDisable()
    {
        
    }
}