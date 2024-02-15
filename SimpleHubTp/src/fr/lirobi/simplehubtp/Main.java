package fr.lirobi.simplehubtp;

import org.bukkit.plugin.java.JavaPlugin;

import fr.lirobi.simplehubtp.commands.HubCommand;
import fr.lirobi.simplehubtp.commands.SetHubCommand;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		System.out.println("[SimpleHubTp] The plugin is on");
		getCommand("sethub").setExecutor(new SetHubCommand());
		getCommand("hub").setExecutor(new HubCommand());
	}
	
	@Override
	public void onDisable() { 
	System.out.println("[SimpleHubTp] The plugin is off");
	}
	
	
	
}
