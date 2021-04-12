package me.marshall.MarshallCore.Cosmetics.Modifiers;

import me.marshall.MarshallCore.Core;
import me.marshall.MarshallCore.MenuSystem.Items;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.HashMap;
import java.util.UUID;


public class PrefixListener implements Listener {

    private HashMap<UUID, String> playerModifier = new HashMap<>();
    private HashMap<UUID, String> bracketInfo = new HashMap<>();
    private HashMap<UUID, String> prefixInfo = new HashMap<>();

    private final String[] prefixItemLore = {"&7Click with this item and follow", "&7the instructions to modify your", "&7prefix"};

    @EventHandler
    public void onModifierItem(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        if (!(item.getType().equals(Material.NAME_TAG))) {
            return;
        }
        if (!(item.hasItemMeta())) {
            return;
        }
        ItemMeta itemMeta = item.getItemMeta();
        PersistentDataContainer container = itemMeta.getPersistentDataContainer();
        NamespacedKey key = new NamespacedKey(Core.getInstance(), "CustomModifier");
        if (!(container.has(key, PersistentDataType.STRING))) {
            return;
        }
        String foundValue = container.get(key, PersistentDataType.STRING);
        if (!(event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK))) {
            event.setCancelled(true);
            return;
        }
        if (!(playerModifier.containsKey(player.getUniqueId()))) {
            if (foundValue.equalsIgnoreCase("&2prefix")) {
                int itemAmount = item.getAmount();

                if (itemAmount > 1) {
                    item.setAmount(itemAmount - 1);
                } else {
                    item = new ItemStack(Material.AIR);
                }
                player.getInventory().setItemInMainHand(item);
                playerModifier.put(player.getUniqueId(), "Attempting");
                player.setMetadata("bracketModifier", new FixedMetadataValue(Core.getInstance(), "prefix"));
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2Please enter what color you would like the brackets to be:"));
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Type 'Cancel' to cancel."));
            }
        } else {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou already have this modifier active."));
        }
    }

    @EventHandler
    public void playerChatEvent(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage();
        if (player.hasMetadata("bracketModifier")) {
            if (message.equalsIgnoreCase("cancel")) {
                prefixUsage(player, "§2You have successfully cancelled the task.", "bracketModifier", true);
                event.setCancelled(true);
                return;
            }
            if (message.length() > 2) {
                prefixUsage(player, "§cYou must define one color code. &7Ex: '&b'.", "bracketModifier", true);
                event.setCancelled(true);
                return;
            } else if (message.contains("k") || message.contains("m") || message.contains("o") || message.contains("l") || message.contains("n") || message.contains("r") || message.contains(" ")) {
                prefixUsage(player, "§cBrackets must be a color.", "bracketModifier", true);
                event.setCancelled(true);
                return;
            } else {
                bracketInfo.put(player.getUniqueId(), message);
                Bukkit.getScheduler().runTaskLater(Core.getInstance(), () -> player.setMetadata("prefixModifier", new FixedMetadataValue(Core.getInstance(), "prefix")), 5);
                player.removeMetadata("bracketModifier", Core.getInstance());
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2Please enter what you would like your prefix to be:"));
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7(Max 16 characters excluding color codes.)"));
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Type 'Cancel' to cancel."));
                event.setCancelled(true);
            }
        }

        if (player.hasMetadata("prefixModifier")) {
            if (message.equalsIgnoreCase("cancel")) {
                prefixUsage(player, "§2You have successfully cancelled the task.", "prefixModifier", true);
                bracketInfo.remove(player.getUniqueId());
                event.setCancelled(true);
                return;
            }
            int colorcodes = 0;
            for (int i = 0; i <= message.length() - 1; i++) {
                char c = message.charAt(i);
                if (c == '&') {
                    colorcodes += 2;
                    if (Character.toLowerCase(message.charAt(i + 1)) == 'k') {
                        prefixUsage(player, "§cYou can not use &k in your prefix.", "prefixModifier", true);
                        event.setCancelled(true);
                        return;
                    }
                }
            }
            if (message.length() - colorcodes > 16) {
                prefixUsage(player, "§cYour prefix can not be greater than 16 characters in length.", "prefixModifier", true);
                event.setCancelled(true);
                return;
            } else if (message.contains(" ")) {
                prefixUsage(player, "§cYou can not use spaces in your prefix.", "prefixModifier", true);
                event.setCancelled(true);
                return;
            } else {
                prefixInfo.put(player.getUniqueId(), message);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2You are about to update your prefix to: " + bracketInfo.get(player.getUniqueId()) + "[" + prefixInfo.get(player.getUniqueId()) + bracketInfo.get(player.getUniqueId()) + "]"));
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2Is this correct? &7(Yes or No)"));
                player.setMetadata("prefixModifierConfirmation", new FixedMetadataValue(Core.getInstance(), "prefixModifierConfirmation"));
                player.removeMetadata("prefixModifier", Core.getInstance());
                event.setCancelled(true);
            }
        }

        if (player.hasMetadata("prefixModifierConfirmation")) {
            switch (Character.toLowerCase(message.charAt(0))) {
                case 'y':
                    try {
                        Bukkit.getScheduler().callSyncMethod(Core.getInstance(), () -> Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + player.getPlayerListName() + " meta addprefix 9999 " + bracketInfo.get(player.getUniqueId()) + "[" + prefixInfo.get(player.getUniqueId()) + bracketInfo.get(player.getUniqueId()) + "]"));
                    } catch (Exception ignored) {
                    }
                    prefixUsage(player, "§2You have successfully changed your nickname.", "prefixModifierConfirmation", false);
                    break;
                case 'n':
                    prefixUsage(player, "§2You have successfully cancelled the task.", "prefixModifierConfirmation", true);
                    break;
            }
        }
    }


    private void prefixUsage(Player player, String message, String metaKey, boolean addItem) {
        player.sendMessage(message);
        if (addItem) {
            player.getInventory().addItem(Items.modifierItem("&2Prefix", prefixItemLore));
        }
        player.removeMetadata(metaKey, Core.getInstance());
        playerModifier.remove(player.getUniqueId());
    }

}
