package functions;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class WaitingClear {
	
	public static void joinStuff(Player p) {
		
		p.getInventory().clear();
		p.getActivePotionEffects().clear();
		
		ItemStack axe = new ItemStack(Material.GOLD_AXE, 1);
		ItemMeta axeM = axe.getItemMeta();
		axeM.setDisplayName("§e§lRejoindre l'arène");
		axe.setItemMeta(axeM);
		
		
		p.setGameMode(GameMode.ADVENTURE);
		p.getInventory().setItem(0, axe);;
		p.updateInventory();
	}
	
	public static void joinTp(Player p) {
		if(p.isOp()) {
			p.performCommand("mv tp waitingroom");
		}
		else {
			p.setOp(true);
			p.performCommand("mv tp waitingroom");
			p.setOp(false);
		}
		
		Location spawn = new Location(Bukkit.getServer().getWorld("waitingroom"), 0, 4, 0);
		p.teleport(spawn);
	}
	
}
