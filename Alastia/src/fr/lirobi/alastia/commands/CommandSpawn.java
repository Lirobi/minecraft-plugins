package fr.lirobi.alastia.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSpawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			Location hub = new Location(Bukkit.getServer().getWorld("world"), 10000.500, 14.000, 10000.500, -90.0f, -1.8f);
			
			p.getInventory().clear();
			
			
			p.getInventory().clear();
			p.getInventory().setHelmet(null);
			p.getInventory().setChestplate(null);
			p.getInventory().setLeggings(null);
			p.getInventory().setBoots(null);
			
			p.setGameMode(GameMode.ADVENTURE);
			
			
			p.sendMessage("§7§l│ §eBienvenue au §6Hub !");
			p.sendMessage("§7§l│ §aLe serveur est en plein développement, si t'es pas staff jsp cque tu fous la mais bon.");
			p.teleport(hub);
		}
		
		return false;
	}

}
