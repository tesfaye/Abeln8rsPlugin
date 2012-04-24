package com.abeln8r.Abeln8rsPlugins.event;

import com.abeln8r.Abeln8rsPlugins.Abeln8rsPlugins;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class Abeln8rBlockListener implements Listener{

	public static Abeln8rsPlugins plugin;

	public Abeln8rBlockListener(Abeln8rsPlugins instance) {
		plugin = instance;
	}

	@EventHandler
        public void onBlockDispense(BlockDispenseEvent event)
        {
            Block block = event.getBlock();
            ItemStack itemstack = event.getItem();
            if(itemstack.getType().isBlock())
            {
                World world = block.getWorld();
                Location loc = block.getLocation();
                switch(block.getData())
                {
                    case 0x2:
                        loc.setZ(loc.getZ() - 1);
                        break;
                    case 0x3:
                        loc.setZ(loc.getZ() + 1);
                        break;
                    case 0x4:
                        loc.setX(loc.getX() - 1);
                        break;
                    case 0x5:
                        loc.setX(loc.getX() + 1);
                        break;
                }
                Block b = world.getBlockAt(loc);
                b.setTypeId(itemstack.getTypeId());
           }
        }   
}