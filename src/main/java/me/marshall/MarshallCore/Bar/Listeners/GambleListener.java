package me.marshall.MarshallCore.Bar.Listeners;

import me.marshall.MarshallCore.Core;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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

import java.util.Objects;
import java.util.Random;
import java.util.UUID;

public class GambleListener implements Listener {

    @EventHandler
    public void onGambleComsumption(PlayerItemConsumeEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        Economy economy = Core.getEconomy();
        if (item.getType() == Material.AIR || !item.hasItemMeta() || !item.getItemMeta().hasDisplayName()) {
            return;
        }
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer container = meta.getPersistentDataContainer();
        NamespacedKey key = new NamespacedKey(Core.getInstance(), "GambleDrink");

        if (container.has(key, PersistentDataType.DOUBLE) || container.has(key, PersistentDataType.INTEGER)) {
            int foundCost = container.get(key, PersistentDataType.INTEGER);
            Bukkit.broadcastMessage("foundcost" + foundCost);

            Random rand = new Random();
            int roll = rand.nextInt(101);
            
            if (roll >= 44) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&2t&fBar&7] &cYou lost."));
            } else {
                economy.depositPlayer(player.getPlayerListName(), foundCost*2);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&2t&fBar&7] &fYou won &2$" + foundCost*2 + "!"));
            }
        }
    }
}
