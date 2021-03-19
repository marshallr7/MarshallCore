package me.marshall.MarshallCore.MenuSystem;

import me.marshall.MarshallCore.MobHunter.MobHunter;
import me.marshall.MarshallCore.SkullCreator;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Items {

    public static ItemStack blackStainedGlass() {
        ItemStack blackStainedGlassPane = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
        ItemMeta blackStainedGlassPaneMeta = blackStainedGlassPane.getItemMeta();
        blackStainedGlassPaneMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', " "));
        blackStainedGlassPane.setItemMeta(blackStainedGlassPaneMeta);
        return blackStainedGlassPane;
    }

    public static ItemStack mobHunterSkull(String url, String name, String[] loreLines) {
        String skin = url;
        ItemStack skull = SkullCreator.itemFromUrl(skin);
        ItemMeta skullMeta = skull.getItemMeta();
        skullMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
        List<String> lore = new ArrayList<>();
        for (int i = 0; i <= loreLines.length - 1; i++) {
            lore.add(ChatColor.translateAlternateColorCodes('&', loreLines[i]));
        }
        skullMeta.setLore(lore);
        skull.setItemMeta(skullMeta);
        return skull;
    }

    public static ItemStack mobHunterNoPermission() {
        ItemStack item = new ItemStack(Material.COAL_BLOCK, 1);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&cYou can not view this hunt."));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&f"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7Defeat the previous tier"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7to gain access to this hunt."));
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        return item;
    }

    public static ItemStack confirmItem(UUID playerUUID) {
        ItemStack item = new ItemStack(Material.LIME_WOOL);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&aConfirm"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&f"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7Click here to start the contract."));
        Integer foundValue = MobHunter.getAttemptedContractPurchase(playerUUID);
        lore.add(ChatColor.translateAlternateColorCodes('&', "&f"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&2Price: $" + foundValue));
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        return item;
    }

    public static ItemStack cancelItem() {
        ItemStack item = new ItemStack(Material.RED_WOOL);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&cCancel"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&f"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7Click here to cancel your purchase."));
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        return item;
    }
}
