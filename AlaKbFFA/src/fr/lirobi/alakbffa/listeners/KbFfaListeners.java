package fr.lirobi.alakbffa.listeners;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KbFfaListeners implements Listener {

	@EventHandler
	public void onTakeDamage(EntityDamageEvent e) {
		
		
		Player p = (Player) e.getEntity();
		if(p.getWorld().getName().equalsIgnoreCase("kb")) {
		p.setHealth(20);
		
		if(e.getCause() == DamageCause.FALL) {
			e.setCancelled(true);
		}
		}
	}
	
	@EventHandler
	public void onWeatherChange(WeatherChangeEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onTakeDamageByAnotherPlayer(EntityDamageByEntityEvent e) {
		Player p = (Player) e.getEntity();
		if(p.getWorld().getName().equalsIgnoreCase("kb")) {
			p.setHealth(20);
		}
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if(p.getWorld().getName().equalsIgnoreCase("kb")) {
		int Y = p.getLocation().getBlockY();
		
		if(Y <= 60) {
			Location kbspawn = new Location(Bukkit.getWorld("kb"), -466.304, 87, 419.500);
			p.teleport(kbspawn);
			ItemStack kbstick = new ItemStack(Material.STICK, 1);
			ItemMeta kbstickM = kbstick.getItemMeta();
			kbstickM.addEnchant(Enchantment.KNOCKBACK, 1, true);
			kbstick.setItemMeta(kbstickM);
			
			ItemStack enderpearl = new ItemStack(Material.ENDER_PEARL, 1);
			
			p.getInventory().clear();
			p.getInventory().setItem(1, enderpearl);
			p.getInventory().setItem(0, kbstick);		
			p.updateInventory();
			

			
		}
		}
	}
	
	
	
}
