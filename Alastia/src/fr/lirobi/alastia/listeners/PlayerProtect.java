package fr.lirobi.alastia.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class PlayerProtect implements Listener {

	@EventHandler
	public void onTakeDamage(EntityDamageEvent e) {
		if(e.getEntity() instanceof Player) {
			
			Player p = (Player) e.getEntity();
			
			e.setCancelled(true);
			p.setHealth(20);
		}
	}
	
	@EventHandler
	public void onLoseFood(FoodLevelChangeEvent e) {
		e.setFoodLevel(20);
	}
	
}
