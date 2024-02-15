package functions;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class stuff {

	public static void stuff(Player p) {
		
		p.getInventory().clear();

		ItemStack helm = new ItemStack(Material.DIAMOND_HELMET, 1);
		ItemMeta helmS = helm.getItemMeta();
		helmS.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		helm.setItemMeta(helmS);
		
		
		ItemStack chest = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
		ItemMeta chestS = chest.getItemMeta();
		chestS.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		chest.setItemMeta(chestS);
		
		
		ItemStack legs = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
		ItemMeta legsS = legs.getItemMeta();
		legsS.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		legs.setItemMeta(legsS);
		
		
		ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS, 1);
		ItemMeta bootsS = boots.getItemMeta();
		bootsS.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		boots.setItemMeta(bootsS);
		
		ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);
		ItemMeta swordS = sword.getItemMeta();
		swordS.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
		sword.setItemMeta(swordS);
		
		
		ItemStack cobble = new ItemStack(Material.COBBLESTONE, 64);
		ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE, 8);
		ItemStack water = new ItemStack(Material.WATER_BUCKET, 1);
		ItemStack lava = new ItemStack(Material.LAVA_BUCKET, 1);
		ItemStack rod = new ItemStack(Material.FISHING_ROD, 1);
		ItemStack pickaxe = new ItemStack(Material.DIAMOND_PICKAXE, 1);
		
		
		p.getInventory().setHelmet(helm);
		p.getInventory().setChestplate(chest);
		p.getInventory().setLeggings(legs);
		p.getInventory().setBoots(boots);
		p.getInventory().setItem(8, cobble);
		p.getInventory().setItem(6, gapple);
		p.getInventory().setItem(3, water);
		p.getInventory().setItem(2, lava);
		p.getInventory().setItem(1, rod);
		p.getInventory().setItem(4, pickaxe);
		
		
		p.getInventory().setItem(0, sword);
	}
	
}
