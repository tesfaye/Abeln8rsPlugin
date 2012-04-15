package com.abeln8r.Abeln8rsPlugins;

import org.bukkit.plugin.java.JavaPlugin;


public class Abeln8rsPlugins extends JavaPlugin
{
    
    public void onEnable()
    {
        this.getCommand("ap").setExecutor(this);
    }
 
    public void onDisable()
    {
    }
}