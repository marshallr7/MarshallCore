package me.marshall.MarshallCore.MobHunter.Listeners;


import io.lumine.xikage.mythicmobs.MythicMobs;
import io.lumine.xikage.mythicmobs.adapters.AbstractLocation;
import io.lumine.xikage.mythicmobs.api.bukkit.events.MythicMobDeathEvent;
import io.lumine.xikage.mythicmobs.api.exceptions.InvalidMobTypeException;
import io.lumine.xikage.mythicmobs.mobs.MythicMob;
import me.marshall.MarshallCore.Core;
import me.marshall.MarshallCore.MobHunter.Menus.CancelMenu;
import me.marshall.MarshallCore.MobHunter.Menus.MobHunterMenu;
import me.marshall.MarshallCore.MobHunter.MobHunter;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;


public class MobHunterListener implements Listener {
    Core plugin = Core.getInstance();

    final int wiseValkyrieKills = plugin.getMobHunterConfig().getInt("wiseValkyrieKills");
    final int zealousValkyrieKills = plugin.getMobHunterConfig().getInt("zealousValkyrieKills");
    final int troublesomeValkyrieKills = plugin.getMobHunterConfig().getInt("troublesomeValkyrieKills");
    final int belligerentValkyrieKills = plugin.getMobHunterConfig().getInt("belligerentValkyrieKills");
    final int transcendedValkyrieKills = plugin.getMobHunterConfig().getInt("transcendedValkyrieKills");

    public HashMap<UUID, Boolean> spawnedBoss = new HashMap<>();


    @EventHandler
    public void onMobHunterKill(MythicMobDeathEvent event) throws InvalidMobTypeException {
        if (!(event.getKiller() instanceof Player)) {
            return;
        }
        Player player = (Player) event.getKiller();
        UUID playerUUID = player.getUniqueId();
        if (!(MobHunter.onGoingMobName.containsKey(playerUUID))) {
            return;
        }
        MythicMob mob = event.getMobType();

        String foundMob = MobHunter.onGoingMobName.get(playerUUID);
        int foundValue = MobHunter.onGoingMobCount.get(playerUUID);

        if (!foundMob.equals(mob.getInternalName())) {
            return;
        }

        MobHunter.updateOnGoingContract(playerUUID);

        AbstractLocation mmLoc = event.getMob().getLocation();
        double mobX = mmLoc.getX();
        double mobY = mmLoc.getY();
        double mobZ = mmLoc.getZ();
        Location location = new Location(player.getWorld(), mobX, mobY, mobZ);

        switch (foundMob) {
            case "WiseValkyrie":
                if (!(foundValue < wiseValkyrieKills)) {
                    return;
                } else {
                    MythicMobs.inst().getAPIHelper().spawnMythicMob("Fenrir", location);
                    spawnedBoss.put(playerUUID, true);
                }
                break;
            case "ZealousValkyrie":
                if (!(foundValue < zealousValkyrieKills)) {
                    return;
                } else {
                    MythicMobs.inst().getAPIHelper().spawnMythicMob("Fenrir", location);
                    spawnedBoss.put(playerUUID, true);
                }
                break;
            case "TroublesomeValkyrie":
                if (!(foundValue < troublesomeValkyrieKills)) {
                    return;
                } else {
                    MythicMobs.inst().getAPIHelper().spawnMythicMob("Fenrir", location);
                    spawnedBoss.put(playerUUID, true);
                }
                break;
            case "BelligerentValkyrie":
                if (!(foundValue < belligerentValkyrieKills)) {
                    return;
                } else {
                    MythicMobs.inst().getAPIHelper().spawnMythicMob("Fenrir", location);
                    spawnedBoss.put(playerUUID, true);
                }
                break;
            case "TranscendedValkyrie":
                if (!(foundValue < transcendedValkyrieKills)) {
                    return;
                } else {
                    MythicMobs.inst().getAPIHelper().spawnMythicMob("Fenrir", location);
                    spawnedBoss.put(playerUUID, true);
                }
                break;

        }

    }

    @EventHandler
    public void onMobHunterDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        UUID playerUUID = player.getUniqueId();
    }

    @EventHandler
    public void playerFileCreation(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        UUID playerUUID = player.getUniqueId();
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

    public void onBossSpawn(String mobName, Location location, UUID playerUUID) throws InvalidMobTypeException {
        MythicMobs.inst().getAPIHelper().spawnMythicMob(mobName, location);
        spawnedBoss.put(playerUUID, true);
    }
}
