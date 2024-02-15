package fr.lirobi.alastia;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.coloredcarrot.api.sidebar.Sidebar;
import com.coloredcarrot.api.sidebar.SidebarString;

import fr.lirobi.alastia.commands.CommandFly;
import fr.lirobi.alastia.commands.CommandMsg;
import fr.lirobi.alastia.commands.CommandSpawn;
import fr.lirobi.alastia.commands.CommandTest;
import fr.lirobi.alastia.listeners.PlayerJoin;
import fr.lirobi.alastia.listeners.PlayerProtect;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		System.out.println("Le plugin vient de s'allumer");
		getCommand("bc").setExecutor(new CommandTest());
		getCommand("hub").setExecutor(new CommandSpawn());
		getCommand("fly").setExecutor(new CommandFly());
		getCommand("msg").setExecutor(new CommandMsg());
		
		PluginManager pm = Bukkit.getPluginManager();
		

		pm.registerEvents(new PlayerJoin(), this);
		pm.registerEvents(new PlayerProtect(), this);
		
		
	}
	
	@Override
	public void onDisable() {
		System.out.println("Le plugin vient de s'éteindre");
	}	
	
}
