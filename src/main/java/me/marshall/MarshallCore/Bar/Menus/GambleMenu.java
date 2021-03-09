package me.marshall.MarshallCore.Bar.Menus;

import me.marshall.MarshallCore.Bar.Drinks;
import me.marshall.MarshallCore.Core;
import me.marshall.MarshallCore.MenuSystem.Items;
import me.marshall.MarshallCore.MenuSystem.Menu;
import me.marshall.MarshallCore.MenuSystem.PlayerMenuUtility;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GambleMenu extends Menu {

    public GambleMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Bar Gamble";
    }

    @Override
    public int getSlots() {
        return 9*3;
    }

    @Override
    public void handleMenu(InventoryClickEvent event) {
        Drinks drink = new Drinks();
        Player player = (Player) event.getWhoClicked();
        Economy economy = Core.getEconomy();
        switch (event.getCurrentItem().getItemMeta().getDisplayName()) {
            case "§6Monkey Shoulder Blended Scotch":
                if (economy.getBalance(player) >= 10000) {
                    player.getInventory().addItem(drink.gambleDrink("&6Monkey Shoulder Blended Scotch", Color.ORANGE, 10000, 35, 50));
                    economy.withdrawPlayer(player, 10000);
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&2t&fBar&7] &cYou can not afford this item."));
                }
                player.closeInventory();
                break;
            case "§6Captain Morgan Rum":
                if (economy.getBalance(player) >= 25000) {
                    player.getInventory().addItem(drink.gambleDrink("&6Captain Morgan Rum", Color.ORANGE, 25000, 43, 50));
                    economy.withdrawPlayer(player, 25000);
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&2t&fBar&7] &cYou can not afford this item."));
                }
                player.closeInventory();
                break;

            case "§6Crown Vanilla":
                if (economy.getBalance(player) >= 50000) {
                    player.getInventory().addItem(drink.gambleDrink("&6Crown Vanilla", Color.ORANGE, 50000, 35, 45));
                    economy.withdrawPlayer(player, 50000);
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&2t&fBar&7] &cYou can not afford this item."));
                }
                player.closeInventory();
                break;

            case "§6Long Island Iced Tea":
                if (economy.getBalance(player) >= 75000) {
                    player.getInventory().addItem(drink.gambleDrink("&6Long Island Iced Tea", Color.ORANGE, 75000, 22, 45));
                    economy.withdrawPlayer(player, 75000);
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&2t&fBar&7] &cYou can not afford this item."));
                }
                player.closeInventory();
                break;

            case "§6Fireball":
                if (economy.getBalance(player) >= 100000) {
                    player.getInventory().addItem(drink.gambleDrink("&6Fireball", Color.ORANGE, 100000, 33, 45));
                    economy.withdrawPlayer(player, 100000);
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&2t&fBar&7] &cYou can not afford this item."));
                }
                player.closeInventory();
                break;

            case "§6Ciroc Summer Citrus":
                if (economy.getBalance(player) >= 125000) {
                    player.getInventory().addItem(drink.gambleDrink("&6Ciroc Summer Citrus", Color.ORANGE, 125000, 35, 40));
                    economy.withdrawPlayer(player, 125000);
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&2t&fBar&7] &cYou can not afford this item."));
                }
                player.closeInventory();
                break;

            case "§fSoju":
                if (economy.getBalance(player) >= 150000) {
                    player.getInventory().addItem(drink.gambleDrink("&fSoju", Color.WHITE, 150000, 24, 40));
                    economy.withdrawPlayer(player, 150000);
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&2t&fBar&7] &cYou can not afford this item."));
                }
                player.closeInventory();
                break;

            case "&f":
                break;
        }
    }

    @Override
    public void setMenuItems() {
        //first row
        inventory.setItem(0, Items.blackStainedGlass());
        inventory.setItem(1, Items.blackStainedGlass());
        inventory.setItem(2, Items.blackStainedGlass());
        inventory.setItem(3, Items.blackStainedGlass());
        inventory.setItem(4, Items.blackStainedGlass());
        inventory.setItem(5, Items.blackStainedGlass());
        inventory.setItem(6, Items.blackStainedGlass());
        inventory.setItem(7, Items.blackStainedGlass());
        inventory.setItem(8, Items.blackStainedGlass());
        //second row
        inventory.setItem(9, Items.blackStainedGlass());
        Drinks createDrink = new Drinks();
        inventory.setItem(10, createDrink.gambleDrink("&6Monkey Shoulder Blended Scotch", Color.ORANGE, 10000, 35, 50));
        inventory.setItem(11, createDrink.gambleDrink("&6Captain Morgan Rum", Color.ORANGE, 25000, 43, 50));
        inventory.setItem(12, createDrink.gambleDrink("&6Crown Vanilla", Color.ORANGE, 50000, 35, 45));
        inventory.setItem(13, createDrink.gambleDrink("&6Long Island Iced Tea", Color.ORANGE, 75000, 22, 45));
        inventory.setItem(14, createDrink.gambleDrink("&6Fireball", Color.ORANGE, 100000, 33, 45));
        inventory.setItem(15, createDrink.gambleDrink("&6Ciroc Summer Citrus", Color.ORANGE, 125000, 35, 40));
        inventory.setItem(16, createDrink.gambleDrink("&fSoju", Color.WHITE, 150000, 24, 40));
        inventory.setItem(17, Items.blackStainedGlass());
        //three row
        inventory.setItem(18, Items.blackStainedGlass());
        inventory.setItem(19, Items.blackStainedGlass());
        inventory.setItem(20, Items.blackStainedGlass());
        inventory.setItem(21, Items.blackStainedGlass());
        inventory.setItem(22, Items.blackStainedGlass());
        inventory.setItem(23, Items.blackStainedGlass());
        inventory.setItem(24, Items.blackStainedGlass());
        inventory.setItem(25, Items.blackStainedGlass());
        inventory.setItem(26, Items.blackStainedGlass());
    }
}
