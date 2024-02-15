package fr.lirobi.lirobiplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTest implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		// TODO Auto-generated method stub
		
		if (sender instanceof Player) {
			Player p = (Player)sender;
			
			if(cmd.getName().equalsIgnoreCase("test")) {
				p.sendMessage("§eBravo tu as réussi §9le test");
				return true;
			}
			
			if(cmd.getName().equalsIgnoreCase("bc")) {
				
				if(args.length == 0) {
					p.sendMessage("§cUsage : /bc <message>");
				}
				
				if(args.length >= 1) {
					
					StringBuilder bc = new StringBuilder();
					for(String part : args) {
						bc.append(part + " ");
					}
					
					Bukkit.broadcastMessage("§c[ANNONCE] §r" + bc.toString());
				}
				
				return true;
			}
		}
		return false;
	}

}
