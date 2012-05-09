package com.abeln8r.Abeln8rsPlugins.commands;

import com.abeln8r.Abeln8rsPlugins.Abeln8rsPlugins;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ECRYCommand extends Abeln8rCommandHandler
{
    public ECRYCommand(Abeln8rsPlugins instance)
    {
        super(instance);
    }
    public boolean onAbeln8rCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        Player player = (Player)sender;
        Location loc = player.getTargetBlock(null, 5).getLocation().add(0, 1, 0);
        player.getWorld().spawn(loc, org.bukkit.entity.EnderCrystal.class);
        return true;
    }
    public String getPermission()
    {
        return "abeln8r.perm.ecry";
    }
    public boolean requiresPlayer()
    {
        return true;
    }
}