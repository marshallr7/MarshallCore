package me.marshall.MarshallCore;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.IOException;

public class BaseListeners implements Listener {

    Core plugin = Core.getInstance();


    //CREATE FILE ON PLAYER LOGIN
    @EventHandler
    public void playerFileCreation(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        new BukkitRunnable() {
            public void run() {
                try {
                    plugin.createCustomConfig(player.getUniqueId(), player.getPlayerListName());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.runTaskAsynchronously(plugin);
    }
}
