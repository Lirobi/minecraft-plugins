package fr.lirobi.alauhcffa;

import org.bukkit.plugin.java.JavaPlugin;

import fr.lirobi.alauhcffa.commands.FfaJoinCommand;
import fr.lirobi.alauhcffa.listeners.BlockBreak;
import fr.lirobi.alauhcffa.listeners.DamageAnnul;
import fr.lirobi.alauhcffa.listeners.Deathj;
import fr.lirobi.alauhcffa.listeners.FfaJoin;
import fr.lirobi.alauhcffa.listeners.PlayerJoin;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		getCommand("joinffa").setExecutor(new FfaJoinCommand());
		getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
		getServer().getPluginManager().registerEvents(new DamageAnnul(), this);
		getServer().getPluginManager().registerEvents(new FfaJoin(), this);
		getServer().getPluginManager().registerEvents(new BlockBreak(), this);
		getServer().getPluginManager().registerEvents(new Deathj(), this);
		System.out.println("AlaUhcFFA démarré !");
	}
	
	@Override
	public void onDisable() {
		System.out.println("AlaUhcFFA éteint !");
	}
	
}
