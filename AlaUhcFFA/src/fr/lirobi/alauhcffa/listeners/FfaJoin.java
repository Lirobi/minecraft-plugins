package fr.lirobi.alauhcffa.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import functions.stuff;

public class FfaJoin implements Listener {

	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		
		Player p = event.getPlayer();
		@SuppressWarnings("unused")
		Action action = event.getAction();
		ItemStack it = event.getItem();
		
		if(it== null) return;
		
		if(it != null && it.getType() == Material.GOLD_AXE && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§e§lRejoindre l'arène")) {
			p.performCommand("joinffa");
			stuff.stuff(p);
		}
	}
	
}
