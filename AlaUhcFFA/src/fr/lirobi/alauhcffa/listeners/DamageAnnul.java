package fr.lirobi.alauhcffa.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class DamageAnnul implements Listener {
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		Player p = (Player) e.getEntity();
		
		if(p.getWorld().getName().equalsIgnoreCase("waitingroom")) {
			if(e.getEntity() instanceof Player) {
				e.setCancelled(true);
			}
		}
		
	}
	@EventHandler
	public void onHunger(FoodLevelChangeEvent e) {
		if(e.getEntity().getWorld().getName().equalsIgnoreCase("waitingroom")) {
			e.setFoodLevel(20);
		}
	}
	
}
