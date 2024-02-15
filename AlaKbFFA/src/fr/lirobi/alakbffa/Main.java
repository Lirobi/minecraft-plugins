package fr.lirobi.alakbffa;

import org.bukkit.plugin.java.JavaPlugin;

import fr.lirobi.alakbffa.commands.kbTpCommand;
import fr.lirobi.alakbffa.listeners.KbFfaListeners;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		System.out.println("[AlaKbFFA] Le plugin est on");
		getCommand("kbtp").setExecutor(new kbTpCommand());
		getServer().getPluginManager().registerEvents(new KbFfaListeners(), this);
	}
	
	@Override
	public void onDisable() {
		System.out.println("[AlaKbFFA] Le plugin est off");
	}
	
}
