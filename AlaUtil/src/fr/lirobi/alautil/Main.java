package fr.lirobi.alautil;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

import fr.lirobi.alautil.commands.CommandHub;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		System.out.println("AlaUtil on");
		getCommand("hub").setExecutor(new CommandHub());
		this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", (PluginMessageListener) this);
	} 
	
	@Override
	public void onDisable() {
		System.out.println("AlaUtil off");
	}
	
}
