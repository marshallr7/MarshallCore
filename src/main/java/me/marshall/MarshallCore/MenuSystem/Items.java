package me.marshall.MarshallCore.MenuSystem;

import me.marshall.MarshallCore.Core;
import me.marshall.MarshallCore.MobHunter.MobHunter;
import me.marshall.MarshallCore.SkullCreator;
import me.marshall.MarshallCore.Utils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Items {


    public static ItemStack modifierItem(String modifierType, String[] loreInfo) {
        ItemStack item = new ItemStack(Material.NAME_TAG);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', modifierType + " Modifier"));
        List<String> lore = new ArrayList<>();
        for (int i = 0; i <= loreInfo.length - 1; i++) {
            lore.add(ChatColor.translateAlternateColorCodes('&', loreInfo[i]));
        }
        NamespacedKey key = new NamespacedKey(Core.getInstance(), "CustomModifier");
        itemMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, modifierType);
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        return item;
    }

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


    public static ItemStack cancelContractItem() {
        ItemStack item = new ItemStack(Material.BARRIER);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&cCancel current contract"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&f"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7Click here to cancel your current contract"));
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        return item;
    }

    public static ItemStack mobHunterXPItem(UUID playerUUID, String mobName) {
        ItemStack item = new ItemStack(Material.OAK_SIGN);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&2Boss Level"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&8Kill bosses to gain experience"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&f"));
        Core plugin = Core.getInstance();
        int exp = plugin.getPlayerFile(playerUUID).getInt("MobHunter." + mobName + "Experience");
        int level;
        if (exp >= 5000000) {
            level = 10;
        } else if (exp >= 2500000) {
            level = 9;
        } else if (exp >= 1000000) {
            level = 8;
        } else if (exp >= 500000) {
            level = 7;
        } else if (exp >= 100000) {
            level = 6;
        } else if (exp >= 25000) {
            level = 5;
        } else if (exp >= 5000) {
            level = 4;
        } else if (exp >= 1000) {
            level = 3;
        } else if (exp >= 150) {
            level = 2;
        } else {
            level = 1;
        }
        if (level < 10) {
            lore.add(ChatColor.translateAlternateColorCodes('&', "&7Current Boss Level: &e" + level));
            lore.add(ChatColor.translateAlternateColorCodes('&', "&f"));
            int nextLevel = level + 1;
            lore.add(ChatColor.translateAlternateColorCodes('&', "&7Experience to level " + nextLevel + ":"));
            double percentage;
            switch (level) {
                case 1:
                    percentage = Utils.percentage(exp, 150);
                    break;
                case 2:
                    percentage = Utils.percentage(exp, 1000);
                    break;
                case 3:
                    percentage = Utils.percentage(exp, 5000);
                    break;
                case 4:
                    percentage = Utils.percentage(exp, 25000);
                    break;
                case 5:
                    percentage = Utils.percentage(exp, 100000);
                    break;
                case 6:
                    percentage = Utils.percentage(exp, 500000);
                    break;
                case 7:
                    percentage = Utils.percentage(exp, 1000000);
                    break;
                case 8:
                    percentage = Utils.percentage(exp, 2500000);
                    break;
                case 9:
                    percentage = Utils.percentage(exp, 5000000);
                    break;
                default:
                    percentage = 0;
            }

            lore.add(ChatColor.translateAlternateColorCodes('&', Utils.percentageBar(percentage)));
            lore.add(ChatColor.translateAlternateColorCodes('&', "&f"));
            lore.add(ChatColor.translateAlternateColorCodes('&', "&eClick to view more"));
        } else {
            lore.add(ChatColor.translateAlternateColorCodes('&', "&7Current Boss Level: &e" + level));
            lore.add(ChatColor.translateAlternateColorCodes('&', "&f"));
            lore.add(ChatColor.translateAlternateColorCodes('&', "&7You are max level!"));
            lore.add(ChatColor.translateAlternateColorCodes('&', "&f"));
            lore.add(ChatColor.translateAlternateColorCodes('&', "&eClick to view more"));
        }


        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        return item;
    }

    //STORE ITEMS
    public static ItemStack storeItem(Material mat, String name, int customDataValue) {
        ItemStack item = new ItemStack(mat);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&2&l" + name));
        List<String> lore = new ArrayList<>();
        itemMeta.setCustomModelData(customDataValue);
        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7Click here to view " + name));
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        return item;
    }
}
