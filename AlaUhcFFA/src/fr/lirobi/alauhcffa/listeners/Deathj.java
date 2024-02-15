package fr.lirobi.alauhcffa.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import functions.WaitingClear;

public class Deathj implements Listener {
	
	@EventHandler
	public void onDeath(PlayerRespawnEvent e) {
		Player p = e.getPlayer();
		WaitingClear.joinStuff(p);
		WaitingClear.joinTp(p);
		
	}
	
}
