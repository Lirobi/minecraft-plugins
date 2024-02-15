package fr.lirobi.alauhcffa.commands;

import org.bukkit.command.Command;
import fr.lirobi.alauhcffa.*;
import fr.lirobi.alauhcffa.listeners.PlayerJoin;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FfaJoinCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		Player p = (Player) sender;
		p.sendMessage("§aTu as rejoint l'arène");
		
		if(p.isOp() == false) {

			p.setOp(true);
			p.performCommand("mv tp world");
			p.setOp(false);
			} else {

				p.performCommand("mv tp world");
			}
		
		
		
		return false;
	}

}
