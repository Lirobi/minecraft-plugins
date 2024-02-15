package fr.lirobi.alastia.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFly implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			
			if(p.getAllowFlight() == true) {
				p.setAllowFlight(false);
				p.setFlying(false);
				p.sendMessage("§eFly off");
			}
			else {
				p.setAllowFlight(true);
				p.setFlying(true);
				p.sendMessage("§eFly on");
			}
			
			
			
			if(!args[0].equalsIgnoreCase("on") && !args[0].equalsIgnoreCase("off")) {
				p.sendMessage("§cLa commande est : /fly <on/off>");
			}
		}
			
		return false;
	}

}
