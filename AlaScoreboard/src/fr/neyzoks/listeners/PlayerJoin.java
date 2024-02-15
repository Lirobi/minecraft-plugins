package fr.neyzoks.listeners;

import fr.neyzoks.Main;
import fr.neyzoks.scoreboard.FastBoard;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class PlayerJoin implements Listener {


    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        FastBoard board = new FastBoard(player);

        board.updateTitle(ChatColor.YELLOW + "§eALASTIA");

        Main.getINSTANCE().boards.put(player.getUniqueId(), board);
    }




}
