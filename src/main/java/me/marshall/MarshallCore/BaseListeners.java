package me.marshall.MarshallCore;

import me.marshall.MarshallCore.Currency.Gems;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.IOException;
import java.util.UUID;

public class BaseListeners implements Listener {

    Core plugin = Core.getInstance();


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        UUID playerUUID = player.getUniqueId();

        //CREATE FILE ON PLAYER LOGIN
        new BukkitRunnable() {
            public void run() {
                try {
                    plugin.createCustomConfig(playerUUID, player.getPlayerListName());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.runTaskAsynchronously(plugin);

        Gems gems = new Gems();
        int gemsBalance = gems.getGems(playerUUID);
        Gems.playerBalances.put(playerUUID, gemsBalance);
    }
}
