package me.marshall.MarshallCore.MobHunter.Listeners;


import me.marshall.MarshallCore.Core;
import me.marshall.MarshallCore.MobHunter.Menus.CancelMenu;
import me.marshall.MarshallCore.MobHunter.Menus.MobHunterMenu;
import me.marshall.MarshallCore.MobHunter.MobHunter;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


public class MobHunterListener implements Listener {



//    public void onMobHunterKill(MythicMobDeathEvent event) {
//        if (!(event.getKiller() instanceof Player)) {
//            return;
//        }
//        Player player = (Player) event.getKiller();
//        UUID playerUUID = player.getUniqueId();
//        if (!(MobHunter.onGoingMobName.containsKey(playerUUID))) {
//            return;
//        }
//        MythicMob mob = event.getMobType();
//        //
//    }


    @EventHandler
    public void playerFileCreation(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        UUID playerUUID = player.getUniqueId();
        Core plugin = Core.getInstance();
        File dataFolder = plugin.getDataFolder();
        File playerDataFolder = new File(dataFolder + "/PlayerData");
        new BukkitRunnable() {
            public void run() {
                try {
                    File playerFile = new File(playerDataFolder, playerUUID + ".yml");
                    if (!playerFile.exists()) {
                        playerFile.createNewFile();
                        System.out.println("§8[§dMarshallCore§8] §aData file for " + player.getPlayerListName() + " created.");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.runTaskAsynchronously(plugin);
    }


    @EventHandler
    public void villagerInteract(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        if (!event.getRightClicked().getCustomName().contains(ChatColor.translateAlternateColorCodes('&', "&fMob Hunter"))) {
            return;
        }
        if (MobHunter.onGoingMobCount.containsKey(player.getUniqueId())) {
            CancelMenu cancelMenu = new CancelMenu(Core.getPlayerMenuUtility(player));
            cancelMenu.open();
        } else {
            MobHunterMenu mainMenu = new MobHunterMenu(Core.getPlayerMenuUtility(player));
            mainMenu.open();
        }

    }
}
