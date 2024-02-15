package fr.lirobi.alautil.commands;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.lirobi.alautil.Main;

public class CommandHub implements CommandExecutor {

	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		Player p = (Player) sender;
		connectToServer(p);
		
		
		
		return false;
	}
	private void connectToServer(Player player) {
	    try {
	        ByteArrayOutputStream b = new ByteArrayOutputStream();
	        DataOutputStream out = new DataOutputStream(b);
	        try {
	            out.writeUTF("Connect");
	            out.writeUTF("lobby");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        player.sendPluginMessage(Main.getPlugin(Main.class), "BungeeCord", b.toByteArray());
	    } catch (org.bukkit.plugin.messaging.ChannelNotRegisteredException e) {
	        Bukkit.getLogger().warning(" ERROR - Usage of bungeecord connect effects is not possible. Your server is not having bungeecord support (Bungeecord channel is not registered in your minecraft server)!");
	    }
	}
	
	
}
