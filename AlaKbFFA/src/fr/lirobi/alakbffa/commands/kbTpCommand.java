package fr.lirobi.alakbffa.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class kbTpCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

		Player p = (Player)sender;
		
		if(p.isOp() == false) {

			p.setOp(true);
			p.performCommand("mv tp kb");
			p.setOp(false);
			} else {

				p.performCommand("mv tp kb");
			}
		
		Location kbspawn = new Location(Bukkit.getWorld("kb"), -466.304, 87, 419.500);
		p.teleport(kbspawn);
		
		ItemStack kbstick = new ItemStack(Material.STICK, 1);
		ItemMeta kbstickM = kbstick.getItemMeta();
		kbstickM.addEnchant(Enchantment.KNOCKBACK, 1, true);
		kbstick.setItemMeta(kbstickM);

		ItemStack enderpearl = new ItemStack(Material.ENDER_PEARL, 1);
		
		p.getInventory().clear();
		p.getInventory().setItem(1, enderpearl);	
		p.getInventory().setItem(0, kbstick);		
		p.updateInventory();
		
		return false;
	}

}
