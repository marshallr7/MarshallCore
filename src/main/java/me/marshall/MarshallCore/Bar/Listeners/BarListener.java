package me.marshall.MarshallCore.Bar.Listeners;

import me.marshall.MarshallCore.Core;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;

public class BarListener implements Listener {

    public HashMap<UUID, Double> playerConsumption = new HashMap<>();

    @EventHandler
    public void onAlcoholConsumption(PlayerItemConsumeEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        UUID playerUUID = player.getUniqueId();
        if (item.getType() == Material.AIR || !item.hasItemMeta() || !Objects.requireNonNull(item.getItemMeta()).hasDisplayName()) {
            return;
        }
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer container = meta.getPersistentDataContainer();
        NamespacedKey key = new NamespacedKey(Core.getInstance(), "drink");
        if (!container.has(key, PersistentDataType.DOUBLE)) {
            return;
        } else {
            double foundValue = container.get(key, PersistentDataType.DOUBLE);
            if (playerConsumption.containsKey(playerUUID)) {
                playerConsumption.put(playerUUID, playerConsumption.get(playerUUID) + foundValue);
            } else {
                playerConsumption.put(playerUUID, foundValue);
            }
        }
        double amount = playerConsumption.get(playerUUID);
        if (amount < 30) {
            return;
        }
        if (amount > 100) {
            // 0-1
            deathChance(player, 2, playerUUID);
            player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 12000, 9));

        } else if (amount > 90) {
            // 0-3
            deathChance(player, 4, playerUUID);
            player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 12000, 8));
        } else if (amount > 80) {
            // 0-5
            deathChance(player, 6, playerUUID);
            player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 12000, 6));
        } else if (amount > 70) {
            // 0-7
            deathChance(player, 8, playerUUID);
            player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 12000, 4));
        } else if (amount > 60) {
            // 0-9
            deathChance(player, 10, playerUUID);
            player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 12000, 3));
        } else if (amount > 50) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 12000, 2));
        } else if (amount > 40) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 12000, 1));
        } else if (amount > 30) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 12000, 0));
        }
    }


    private void deathChance(Player player, int number, UUID playerUUID) {
        Random rand = new Random();
        int randomDeath = rand.nextInt(number);
        if (randomDeath == 1) {
            playerConsumption.put(playerUUID, (double) 0);
            Random random = new Random();
            int randomLocation = random.nextInt(3);
            switch (randomLocation) {
                case 0:
                    Location location = new Location(Bukkit.getWorld("spawn"), 187, 68, -1301, -179.5f, 37.2f);
                    alcoholTeleport(player, location);
                    break;
                case 1:
                    Location locationTwo = new Location(Bukkit.getWorld("spawn"), -40.5, 71, -1329.5, -90, 0);
                    alcoholTeleport(player, locationTwo);
                    break;
                case 2:
                    Location locationThree = new Location(Bukkit.getWorld("spawn"), 169.384, 82, -1293.990, 90, 40);
                    alcoholTeleport(player, locationThree);
                    break;
            }
        } else {
            player.sendRawMessage(ChatColor.translateAlternateColorCodes('&', "&7[&2t&fBar&7] &fYou are close to blacking out..."));
        }
    }

    private void alcoholTeleport(Player player, Location teleportLocation) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 600, 9));
        Bukkit.getScheduler().runTaskLater(Core.getInstance(), () -> player.teleport(teleportLocation), 60);
        Bukkit.getScheduler().runTaskLater(Core.getInstance(), () -> player.removePotionEffect(PotionEffectType.BLINDNESS), 100);
        Bukkit.getScheduler().runTaskLater(Core.getInstance(), () -> player.removePotionEffect(PotionEffectType.CONFUSION), 100);
        Bukkit.getScheduler().runTaskLater(Core.getInstance(), () -> player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&2t&fBar&7] &cYou blacked out and woke up in a random location.")), 110);
    }


    public void onGambleConsumption(PlayerItemConsumeEvent event) {

    }
}
