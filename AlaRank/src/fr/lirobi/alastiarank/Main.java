package fr.lirobi.alastiarank;

import org.bukkit.plugin.java.JavaPlugin;

import fr.lirobi.alastiarank.commands.CommandRank;
import fr.lirobi.alastiarank.listeners.RankListeners;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		System.out.println("AlaRank démarré"); 
		getCommand("rankadmin").setExecutor(new CommandRank());
		getServer().getPluginManager().registerEvents(new RankListeners(), this);
	}

	@Override
	public void onDisable() {
		System.out.println("AlaRank éteint");
	}
	
}
