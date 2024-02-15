package fr.neyzoks.listeners;

import fr.neyzoks.Main;
import fr.neyzoks.scoreboard.FastBoard;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;



public class PlayerQuit implements Listener {


    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();

        FastBoard board = Main.getINSTANCE().boards.remove(player.getUniqueId());

        if (board != null) {
            board.delete();
        }
    }
}
