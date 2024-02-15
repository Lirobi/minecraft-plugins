package fr.lirobi.alastiarank.listeners;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class RankListeners implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		e.setJoinMessage(null);
	
	if(getAdmin(p)) { 
			p.setDisplayName("§cAdmin §f" + p.getName());
			
			p.setCustomName("§cAdmin §f" + p.getName());
			p.setCustomNameVisible(true);
	}		
		
	final World world = Bukkit.getWorld("world");
	for (Player player : world.getPlayers()) {
		player.sendMessage(p.getDisplayName() + "§e à rejoint le serveur.");
	}
		
	}
	
	@EventHandler 
	public void onLeave(PlayerQuitEvent e) {
		e.setQuitMessage(null);
	}
	
	@EventHandler
	public void onWorldChange(PlayerChangedWorldEvent e) {
		Player p = e.getPlayer();
		if(p.getWorld().getName().equalsIgnoreCase("world") && getAdmin(p)) {
			p.setFlying(true);
			p.setAllowFlight(true);
		} else {
			p.setFlying(false);
			p.setAllowFlight(false);
		}
	}
	
	
	@EventHandler
	public void chatFormat(AsyncPlayerChatEvent event){
	Player p = event.getPlayer();
	String format = p.getDisplayName();
	format += "§8§l ≫ §r§7";
	format += event.getMessage();
	if(p.getWorld().getName().equalsIgnoreCase("world")) {
		final World world = Bukkit.getWorld("world");
		for (Player player : world.getPlayers()) {
			player.sendMessage(format);
		}
	} 
	if(p.getWorld().getName().equalsIgnoreCase("kb")) {
		final World world = Bukkit.getWorld("kb");
		for (Player player : world.getPlayers()) {
			player.sendMessage(format);
		}
	} 
	if(p.getWorld().getName().equalsIgnoreCase("kitpvp")) {
		final World world = Bukkit.getWorld("kitpvp");
		for (Player player : world.getPlayers()) {
			player.sendMessage(format);
		}
	} 
	
	
		
		event.setCancelled(true);
		event.setFormat(format);
		
	
	
	
	
}
	
public boolean getAdmin(Player p) {
	String playerName = p.getDisplayName();
	if(playerName.equalsIgnoreCase("LirobiYoutube")) {
		return true;
	}
	if(playerName.equalsIgnoreCase("MiniCookie_")) {
		return true;
	}
	if(playerName.equalsIgnoreCase("Darkin88")) {
		return true;
	}
	if(playerName.equalsIgnoreCase("Ko0vAniiX")) {
		return true;
	}
	else {
		return false;
	}
}
	
	
}
