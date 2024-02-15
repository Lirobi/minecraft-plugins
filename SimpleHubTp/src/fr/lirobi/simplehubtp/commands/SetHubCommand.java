package fr.lirobi.simplehubtp.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class SetHubCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			Location location = p.getLocation();
		
		
			  ArmorStand as = (ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND); //Spawn the ArmorStand
			  as.setVisible(false); //Makes the ArmorStand invisible
			  as.setGravity(false); //Make sure it doesn't fall
			  as.setCanPickupItems(false); //I'm not sure what happens if you leave this as it is, but you might as well disable it
			  as.setCustomName("§8hub"); //Set this to the text you want
			  as.setCustomNameVisible(false); //This makes the text appear no matter if your looking at the entity or not
			  final ArmorStand armorStand = as;
		}
		return false;
	}

}
