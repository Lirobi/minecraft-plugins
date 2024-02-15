package fr.lirobi.lirobiplugin;

import org.bukkit.plugin.java.JavaPlugin;

import fr.lirobi.lirobiplugin.commands.CommandFly;
import fr.lirobi.lirobiplugin.commands.CommandSpawn;
import fr.lirobi.lirobiplugin.commands.CommandTest;
import fr.lirobi.lirobiplugin.listeners.PluginMessages;
import fr.lirobi.lirobiplugin.msg.CommandMsg;
import me.xxnurioxx.api.playercount.EasyPlayerCount;

public class MainPlugin extends JavaPlugin {
	
	private EasyPlayerCount API;
	
	@Override
	public void onEnable() {
		System.out.println("Le plugin vient de s'allumer");
		getCommand("test").setExecutor(new CommandTest());
		getCommand("bc").setExecutor(new CommandTest());
		getCommand("hub").setExecutor(new CommandSpawn());
		getCommand("fly").setExecutor(new CommandFly());
		getCommand("msg").setExecutor(new CommandMsg());
		getServer().getPluginManager().registerEvents(new LirobiPluginListeners(), this);
		getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", new PluginMessages());
		API = (EasyPlayerCount) getServer().getPluginManager().getPlugin("EasyPlayerCountAPI");
	}
	
	@Override
	public void onDisable() {
		System.out.println("Le plugin vient de s'éteindre");
	}
}
