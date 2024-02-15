package fr.neyzoks;

import fr.neyzoks.listeners.PlayerJoin;
import fr.neyzoks.listeners.PlayerQuit;
import fr.neyzoks.scoreboard.FastBoard;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class Main extends JavaPlugin  {

    public static final Map<UUID, FastBoard> boards = new HashMap<>();
    public static Main INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new PlayerJoin(), this);
        pm.registerEvents(new PlayerQuit(), this);

        getServer().getScheduler().runTaskTimer(this, () -> {
            for (FastBoard board : boards.values()) {
                updateBoard(board);
            }
        }, 0, 20);
    }


    private void updateBoard(FastBoard board) {
        board.updateLines(
                "",
                " §7Grade: ",
                "",
                " §7Niveau: §e",
                " §7Coins: §b",
                "",
                " §7Hub: §cHub01",
                " §7Joueurs: §c" + Bukkit.getOnlinePlayers().size(),
                "",
                " §6play.alastia.fr"
        );
    }

    public static Main getINSTANCE() {
        return INSTANCE;
    }
}