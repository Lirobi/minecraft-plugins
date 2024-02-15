package fr.lirobi.alastia.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.coloredcarrot.api.sidebar.Sidebar;
import com.coloredcarrot.api.sidebar.SidebarString;

import fr.lirobi.alastia.Main;

public class PlayerJoin implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
	
	e.setJoinMessage(null);
		
	Player p = e.getPlayer();
	
	p.performCommand("hub");
	
	int playercount = 0;
	for(Player players : Bukkit.getServer().getOnlinePlayers()) {
		playercount += 1;
	}
	String playercountserver = String.valueOf(playercount);
	
	String rank = "Player";
	
	if(getAdmin(p) == true) {
		rank = "§cAdmin";
	} else {
		rank = "Player";
	}
		
	//SidebarString line1 = new SidebarString(" ");
	//SidebarString line2 = new SidebarString(" §7Pseudo : §e" + p.getName());
	//SidebarString line3 = new SidebarString(" §7Grade : §cAdmin");
	//SidebarString line4 = new SidebarString(" ");
	//SidebarString line5 = new SidebarString(" §7Coins : §b 537 ䷂");
	//SidebarString line6 = new SidebarString(" ");
	//SidebarString line7 = new SidebarString(" §7Hub : §cHub01");
	//SidebarString line8 = new SidebarString(" §7Joueurs : §c" + playercountserver);
	//SidebarString line9 = new SidebarString(" §6play.alastia.fr");
	//Sidebar mySidebar = new Sidebar("§eALASTIA", Main.getPlugin(Main.class), 20);
	
	//mySidebar.addEntry(line1);
	//mySidebar.addEntry(line2);
	//mySidebar.addEntry(line3);
	//mySidebar.addEntry(line4);
	//mySidebar.addEntry(line5);
	//mySidebar.addEntry(line6);
	//mySidebar.addEntry(line7);
	//mySidebar.addEntry(line8);
	//mySidebar.addEntry(line9);
	
	//mySidebar.showTo(p);
	
	}

	
	public boolean getAdmin(Player p) {
		String playerName = p.getName();
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
