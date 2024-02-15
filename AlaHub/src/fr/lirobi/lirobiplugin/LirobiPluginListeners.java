package fr.lirobi.lirobiplugin;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.Statistic;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;

import fr.lirobi.lirobiplugin.*;
import fr.lirobi.lirobiplugin.listeners.*;
import me.xxnurioxx.api.playercount.EasyPlayerCount;



public class LirobiPluginListeners implements Listener {

	private EasyPlayerCount API;
	
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		event.setJoinMessage(null);
		
		Player p = event.getPlayer();
		if(p.isOp() == false) {

			p.setOp(true);
			p.performCommand("mv tp world");
			p.setOp(false);
			} else {

				p.performCommand("mv tp world");
			}
		
		p.getInventory().clear();
		p.getInventory().setHelmet(null); 
		p.getInventory().setChestplate(null);
		p.getInventory().setLeggings(null);
		p.getInventory().setBoots(null);
		
		p.setHealth(20);
		
		
		
		ItemStack customcompass = new ItemStack(Material.COMPASS, 1);
		ItemMeta compassM = customcompass.getItemMeta();
		compassM.setDisplayName("§e§lMenu");
		compassM.setLore(Arrays.asList("§eClic droit pour ouvrir", " ", "§7Ouvrez tous les menus", "§7de jeu"));
		compassM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
		customcompass.setItemMeta(compassM);
		
		
		ItemStack customhead = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
		SkullMeta customheadM = (SkullMeta) customhead.getItemMeta();
		customheadM.setOwner(p.getName());
		customheadM.setDisplayName("§b§lStats");
		customheadM.setLore(Arrays.asList("§eClic droit pour ouvrir", " ", "§7Affichez vos statistiques"));
		customhead.setItemMeta(customheadM);
		
		ItemStack web = new ItemStack(Material.TRIPWIRE_HOOK, 1);
		ItemMeta webM = web.getItemMeta();
		webM.setDisplayName("§e§lLiens utiles");
		webM.setLore(Arrays.asList("§eClic droit pour ouvrir", " ", "§7Afficher les lien utiles"));
		web.setItemMeta(webM);
		
		p.getInventory().setItem(3, web);
		p.getInventory().setItem(2, customhead);
		p.getInventory().setItem(0, customcompass);
		
		p.updateInventory();
		
		p.setGameMode(GameMode.ADVENTURE);
		
		
			
		
		
		
		
		Location hub = new Location(Bukkit.getWorld("world"), 0.500, 68, 0.500, -0.2f, -14.2f);
		p.teleport(hub);
		
		
		
		
		if(!p.hasPlayedBefore()) {
			Bukkit.broadcastMessage(p.getName() + "§e est nouveau sur le serveur ! Bienvenue");
			
		
		}
	}

	
	
	@EventHandler
    public void onItemDrop (PlayerDropItemEvent event) {
		Player p = event.getPlayer();
			if(p.getWorld().getName().equalsIgnoreCase("world")) {
				event.setCancelled(true);
			}
			
	}
	
	@EventHandler
	public void onFoodLevelChange(FoodLevelChangeEvent event)  {
		HumanEntity p = event.getEntity();
		if(p.getWorld().getName().equalsIgnoreCase("world")) {
		
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent event) {
		Player p = event.getPlayer();

		if(p.getWorld().getName().equalsIgnoreCase("world")) {
		int locY = (int) p.getLocation().getY();
		if(locY <= 10) {
			Location hub = new Location(Bukkit.getWorld("world"), 0.500, 68, 0.500, -0.2f, -14.2f);
			p.teleport(hub);
			p.sendMessage("§cAttention, tu est tombé très bas :(");
		}
		}
	}
	
	@EventHandler
    public void onHit(EntityDamageEvent event){
		Player p = (Player) event.getEntity();
		if(p.getWorld().getName().equalsIgnoreCase("world")) {
			if (event.getEntity() instanceof Player){
            event.setCancelled(true);
			}
		}
    }
	
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		
		Player p = event.getPlayer();
		@SuppressWarnings("unused")
		Action action = event.getAction();
		ItemStack it = event.getItem();
		
		if(it== null) return;
		
		if(it != null && it.getType() == Material.COMPASS && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§e§lMenu")) {
			Inventory inv = Bukkit.createInventory(null, 54, "§8Menu de jeu");

			String serverName = "uhcffa";
			
			int uhcList = PluginMessages.getServerCount(p, serverName);
			
			ItemStack axe = new ItemStack(Material.GOLD_AXE, 1);
			ItemMeta axeM = axe.getItemMeta();
			axeM.setDisplayName("§a§lUHC FFA");
			axeM.setLore(Arrays.asList("§eClic gauche pour rejoindre", " ", "§7Faites le plus de kills ", "§7et restez en vie."," ", "§7Joueurs en ligne : " + uhcList));
			axe.setItemMeta(axeM);
			
			ItemStack slimeball = new ItemStack(Material.SLIME_BALL, 1);
			ItemMeta slimeballM = slimeball.getItemMeta();
			slimeballM.setDisplayName("§a§lJump");
			slimeballM.setLore(Arrays.asList("§eClic gauche pour rejoindre", " ", "§7Sautez de blocs en blocs jusqu'a", "§7finir le parcours.", "§7Bonne chance."));
			slimeball.setItemMeta(slimeballM);
			
			
			@SuppressWarnings("deprecation")
			ItemStack barrier = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.RED.getData());
			ItemMeta barrierM = barrier.getItemMeta();
			barrierM.setDisplayName("§c§k§l§oA venir !");
			barrierM.setLore(Arrays.asList("§eProchainement...", " ", "§7Ce jeu est en cours ", "§7d'élaboration/développement.", "§7le serveur ne compte", "§7qu'un seul développeur", "§7dans ses rangs."));
			barrier.setItemMeta(barrierM);
			
			
			inv.setItem(14+ 9, barrier);
			inv.setItem(15+ 9, barrier);
			inv.setItem(20+ 9, barrier);
			inv.setItem(21+ 9, barrier);
			inv.setItem(22+ 9, barrier);
			inv.setItem(23+ 9, barrier);
			inv.setItem(24+ 9, barrier);
			inv.setItem(12+ 9, slimeball);
			inv.setItem(13+ 9, barrier);
			inv.setItem(11+ 9, axe);
			
			//-488 10 381
			
			p.openInventory(inv);
			

			if(p.getScoreboard().getPlayerTeam(p) != null) {
				p.setDisplayName(p.getName());
				String team = p.getScoreboard().getPlayerTeam(p).getPrefix().toString();
				p.setDisplayName(team + p.getName());
				}
		}
		if(it != null && it.getType() == Material.SKULL_ITEM && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§b§lStats")) {
			Inventory statsinv = Bukkit.createInventory(null, 45, "§8Statistiques de jeu");
			
			ItemStack customhead = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
			SkullMeta customheadM = (SkullMeta) customhead.getItemMeta();
			customheadM.setOwner(p.getName());
			customheadM.setDisplayName("§e§lCompte");
			customheadM.setLore(Arrays.asList(" ", "§fPseudo : " + p.getDisplayName(), "§fNiveau : §a" + p.getLevel()));
			customhead.setItemMeta(customheadM);
			
			ItemStack sword = new ItemStack(Material.IRON_SWORD, 1);
			ItemMeta swordM = sword.getItemMeta();
			swordM.setDisplayName("§e§lKills et morts");
			swordM.setLore(Arrays.asList(" ", "§fKills : §a " + p.getStatistic(Statistic.PLAYER_KILLS), "§fMorts : §a " + p.getStatistic(Statistic.DEATHS)));
			sword.setItemMeta(swordM);
			
			statsinv.setItem(21, sword);
			statsinv.setItem(20 , customhead);
			
			p.openInventory(statsinv);
		}
		if(it != null && it.getType() == Material.TRIPWIRE_HOOK && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§e§lLiens utiles")) {
			Inventory linkinv = Bukkit.createInventory(null, 27, "§8Liens utiles");
			
			ItemStack string = new ItemStack(Material.STRING, 1);
			ItemMeta stringM = string.getItemMeta();
			stringM.setDisplayName("§e§lLien du site internet");
			stringM.setLore(Arrays.asList("§eClic droit pour afficher"));
			string.setItemMeta(stringM);
			
			linkinv.setItem(3 + 9, string);
			
			p.openInventory(linkinv);
			
		}
	}
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		e.setCancelled(true);
	}
	
	
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		
		Inventory inv = event.getInventory();
		Player p = (Player) event.getWhoClicked();
		ItemStack current = event.getCurrentItem();


			
		if(current == null) return;
		
		if(p.getWorld().getName().equalsIgnoreCase("world")) {
			event.setCancelled(true);
		}
		
		if(inv.getName().equalsIgnoreCase("§8Menu de jeu")) {
			
			event.setCancelled(true);
			
			if(current.getType() == Material.GOLD_AXE) {
				String serverName = "uhcffa";
				p.closeInventory();
				connectToServer(p, serverName);
			}
			
			if(current.getType() == Material.SLIME_BALL) {
				p.closeInventory();
				Location jump = new Location(Bukkit.getWorld("world"), -11.856, 66, 13.682, 38.7f, 20.2f);
				p.teleport(jump);
				p.sendMessage("§eTu as été téléporté au Jump, tu n'as plus qu'a sauter de blocs en blocs et suivre le parcours sans tomber. Bonne chance.");
			}
				
			if(current.getType() == Material.IRON_SWORD) {
				p.closeInventory();
				p.performCommand("kitpvp");
				p.sendMessage("§eTu as rejoint le KitPvp, bonne chance !");
			}
				
				
				
			
			
		}
		
		if(inv.getName().equalsIgnoreCase("§8Liens utiles")) {
			event.setCancelled(true);
			
			if(current.getType() == Material.STRING) {
				p.closeInventory();
				
				TextComponent msg = new TextComponent("§eLien du site internet (cliquez sur ce §emessage)");
				msg.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://Alastia.andreigigi39.repl.co"));
				p.spigot().sendMessage(msg);
			}
			
		}
	}
	
	public ItemStack getItem(Material material, String customName) {
		ItemStack it = new ItemStack(material, 1);
		ItemMeta itM = it.getItemMeta();
		itM.setDisplayName(customName);
		it.setItemMeta(itM);
		return it;
	
	}
	
	

	
	private void connectToServer(Player player, String server) {
	    try {
	        ByteArrayOutputStream b = new ByteArrayOutputStream();
	        DataOutputStream out = new DataOutputStream(b);
	        try {
	            out.writeUTF("Connect");
	            out.writeUTF(server);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        player.sendPluginMessage(MainPlugin.getPlugin(MainPlugin.class), "BungeeCord", b.toByteArray());
	    } catch (org.bukkit.plugin.messaging.ChannelNotRegisteredException e) {
	        Bukkit.getLogger().warning(" ERROR - Usage of bungeecord connect effects is not possible. Your server is not having bungeecord support (Bungeecord channel is not registered in your minecraft server)!");
	    }
	}

} 









