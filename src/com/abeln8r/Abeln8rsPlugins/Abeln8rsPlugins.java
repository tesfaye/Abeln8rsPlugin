package com.abeln8r.Abeln8rsPlugins;

import com.abeln8r.Abeln8rsPlugins.commands.*;
import org.bukkit.plugin.java.JavaPlugin;

public class Abeln8rsPlugins extends JavaPlugin
{
    public void onEnable()
    {
        getCommand("tk").setExecutor(new TalkCommand(this));
        getCommand("hide").setExecutor(new HideCommand(this));
    }
    public void onDisable()
    {
        
    }
}