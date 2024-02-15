package fr.lirobi.alauhcffa.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.Plugin;

public class BlockBreak implements Listener {

	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		if(e.getPlayer().getWorld().getName().equalsIgnoreCase("world")) {
			if(e.getBlock().getType() != Material.COBBLESTONE && e.getBlock().getType() != Material.OBSIDIAN) {
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void blockBreack(BlockPlaceEvent e) {
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this, new Runnable() {
		     public void run() {
		         e.setCancelled(true);
		     }
		}, (60 * 20)); 
	}
	
	
}
