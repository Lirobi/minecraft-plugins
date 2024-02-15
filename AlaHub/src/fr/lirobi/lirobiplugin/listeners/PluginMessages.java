package fr.lirobi.lirobiplugin.listeners;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import fr.lirobi.lirobiplugin.MainPlugin;

public class PluginMessages implements PluginMessageListener {

	private final static HashMap<String, Integer> serverCount = new HashMap<>();
	
	
	public static void getCount(Player player, String server) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("PlayerCount");
        out.writeUTF(server);

        player.sendPluginMessage(MainPlugin.getPlugin(MainPlugin.class), "BungeeCord", out.toByteArray());
    }
	
	
	@Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (!channel.equals("BungeeCord")) {
            return;
        }

        ByteArrayDataInput in = ByteStreams.newDataInput(message);
        String subchannel = in.readUTF();

        if (subchannel.equals("PlayerCount")) {
            String server = in.readUTF();
            serverCount.put(server, in.readInt());
        }
    }

	public static int getServerCount(Player p, String server) {
        getCount(p, server);
        if (serverCount.get(server) != null) {
            return serverCount.get(server);
        }
        else {
        	return 100;
        }
    }

}
