package fr.lirobi.alauhcffa.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import functions.WaitingClear;
public class PlayerJoin implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		WaitingClear.joinStuff(p);
		WaitingClear.joinTp(p);
		
		e.setJoinMessage("§a(+) " + p.getDisplayName());
				
	}
	
}
