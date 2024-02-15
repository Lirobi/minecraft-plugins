package fr.lirobi.lirobiplugin.msg;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandMsg implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		Player s = (Player) sender;
		
		if(args.length >=2 ) {

			String targetname = args[0];
			Player target = Bukkit.getPlayer(targetname);
			String message = "";
			
			for(int i = 1; i != args.length; i++) {

                message += args[i] + " ";

            }
			
			s.sendMessage("§aEnvoyé à " + target.getDisplayName() + "§7 : §e" + message);
			target.sendMessage("§aReçu de " + s.getDisplayName() + "§7 : §e" + message);
			
		} 
		if(args.length <= 1) {
			s.sendMessage("§cLa commande est : /msg <destinataire> <message>");
		}
		
		
		return false;
	}

}
