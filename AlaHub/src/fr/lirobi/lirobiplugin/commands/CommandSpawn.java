package fr.lirobi.lirobiplugin.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class CommandSpawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(p.isOp() == false) {

				p.setOp(true);
				p.performCommand("mv tp world");
				p.setOp(false);
				} else {

					p.performCommand("mv tp world");
				}
			
			Location hub = new Location(Bukkit.getServer().getWorld("world"), 0.500, 68, 0.500, -0.2f, -14.2f);
			
			p.getInventory().clear();
			
			
			p.getInventory().clear();
			p.getInventory().setHelmet(null);
			p.getInventory().setChestplate(null);
			p.getInventory().setLeggings(null);
			p.getInventory().setBoots(null);
			
			
			
			ItemStack customcompass = new ItemStack(Material.COMPASS, 1);
			ItemMeta compassM = customcompass.getItemMeta();
			compassM.setDisplayName("§e§lMenu");
			compassM.setLore(Arrays.asList("§eClic droit pour ouvrir", " ", "§7Ouvrez tous les menus", "§7de jeu"));
			compassM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
			customcompass.setItemMeta(compassM);
			p.getInventory().setItem(0, customcompass);
			
			ItemStack customhead = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
			SkullMeta customheadM = (SkullMeta) customhead.getItemMeta();
			customheadM.setOwner(p.getName());
			customheadM.setDisplayName("§b§lStats");
			customheadM.setLore(Arrays.asList("§eClic droit pour ouvrir", " ", "§7Affichez vos statistiques"));
			customhead.setItemMeta(customheadM);ItemStack web = new ItemStack(Material.TRIPWIRE_HOOK, 1);
			ItemMeta webM = web.getItemMeta();
			webM.setDisplayName("§e§lLiens utiles");
			webM.setLore(Arrays.asList("§eClic droit pour ouvrir", " ", "§7Afficher les lien utiles"));
			web.setItemMeta(webM);
			
			p.getInventory().setItem(3, web);
			
			p.getInventory().setItem(2, customhead);
			
			p.updateInventory();
			
			p.setGameMode(GameMode.ADVENTURE);
			
			
			p.sendMessage("§eVous avez été téléporté au hub !");
			p.teleport(hub);
		}
		
		return false;
	}

}
