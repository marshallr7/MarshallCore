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

public class BarMenu extends Menu {

    public BarMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Bar";
    }

    @Override
    public int getSlots() {
        return 9*4;
    }

    @Override
    public void handleMenu(InventoryClickEvent event) {
        Drinks drink = new Drinks();
        Player player = (Player) event.getWhoClicked();
        Economy economy = Core.getEconomy();
        switch(event.getCurrentItem().getItemMeta().getDisplayName()) {
            case "§6Corona Extra":
                if (economy.getBalance(player) >= 70) {
                    player.getInventory().addItem(drink.alcoholDrink("&6Corona Extra", Color.ORANGE, 70.00, 4.6));
                    economy.withdrawPlayer(player, 70);
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&2t&fBar&7] &cYou can not afford this item."));
                }
                player.closeInventory();
                break;
            case "§6Michelob Ultra":
                if (economy.getBalance(player) >= 60) {
                    player.getInventory().addItem(drink.alcoholDrink("&6Michelob Ultra", Color.ORANGE, 60.00, 4.2));
                    economy.withdrawPlayer(player, 60);
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&2t&fBar&7] &cYou can not afford this item."));
                }
                player.closeInventory();
                break;

            case "§6Bud Light Platinum":
                if (economy.getBalance(player) >= 80) {
                    player.getInventory().addItem(drink.alcoholDrink("&6Bud Light Plantinum", Color.ORANGE, 80.00, 6));
                    economy.withdrawPlayer(player, 80);
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&2t&fBar&7] &cYou can not afford this item."));
                }
                player.closeInventory();
                break;
            case "§6Coors Light":
                if (economy.getBalance(player) >= 55) {
                    player.getInventory().addItem(drink.alcoholDrink("&6Coors Light", Color.ORANGE, 55.00, 4.2));
                    economy.withdrawPlayer(player, 55);
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&2t&fBar&7] &cYou can not afford this item."));
                }
                player.closeInventory();
                break;

            case "§6Budweiser":
                if (economy.getBalance(player) >= 50) {
                    player.getInventory().addItem(drink.alcoholDrink("&6Budweiser", Color.ORANGE, 50.00, 5));
                    economy.withdrawPlayer(player, 50);
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&2t&fBar&7] &cYou can not afford this item."));
                }
                player.closeInventory();
                break;

            case "§6Heineken":
                if (economy.getBalance(player) >= 70) {
                    player.getInventory().addItem(drink.alcoholDrink("&6Heineken", Color.ORANGE, 70.00, 5));
                    economy.withdrawPlayer(player, 70);
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&2t&fBar&7] &cYou can not afford this item."));
                }
                player.closeInventory();
                break;

            case "§6Guiness":
                if (economy.getBalance(player) >= 90) {
                    player.getInventory().addItem(drink.alcoholDrink("&6Guiness", Color.ORANGE, 90.00, 4.2));
                    economy.withdrawPlayer(player, 90);
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&2t&fBar&7] &cYou can not afford this item."));
                }
                player.closeInventory();
                break;

            case "§cAlabama Slammer":
                if (economy.getBalance(player) >= 300) {
                    player.getInventory().addItem(drink.alcoholDrink("&cAlabama Slammer", Color.RED, 300.00, 12.5));
                    economy.withdrawPlayer(player, 300);
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&2t&fBar&7] &cYou can not afford this item."));
                }
                player.closeInventory();
                break;

            case "§eLemon Drop":
                if (economy.getBalance(player) >= 700) {
                    player.getInventory().addItem(drink.alcoholDrink("&eLemon Drop", Color.YELLOW, 700.00, 6));
                    economy.withdrawPlayer(player, 700);
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&2t&fBar&7] &cYou can not afford this item."));
                }
                player.closeInventory();
                break;

            case "§aMelon Ball":
                if (economy.getBalance(player) >= 699) {
                    player.getInventory().addItem(drink.alcoholDrink("&aMelon Ball", Color.LIME, 699.00, 17));
                    economy.withdrawPlayer(player, 699);
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&2t&fBar&7] &cYou can not afford this item."));
                }
                player.closeInventory();
                break;

            case "§fKamikaze":
                if (economy.getBalance(player) >= 807) {
                    player.getInventory().addItem(drink.alcoholDrink("&fKamikaze", Color.WHITE, 807.00, 25));
                    economy.withdrawPlayer(player, 807);
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&2t&fBar&7] &cYou can not afford this item."));
                }
                player.closeInventory();
                break;

            case "§4Washington Apple":
                if (economy.getBalance(player) >= 554) {
                    player.getInventory().addItem(drink.alcoholDrink("&4Washington Apple", Color.MAROON, 554.00, 16));
                    economy.withdrawPlayer(player, 554);
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&2t&fBar&7] &cYou can not afford this item."));
                }
                player.closeInventory();
                break;

            case "§eVegas Bomb":
                if (economy.getBalance(player) >= 525) {
                    player.getInventory().addItem(drink.alcoholDrink("&eVegas Bomb", Color.YELLOW, 525, 11));
                    economy.withdrawPlayer(player, 525);
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&2t&fBar&7] &cYou can not afford this item."));
                }
                player.closeInventory();
                break;
            case "§6Jägerbomb":
                if (economy.getBalance(player) >= 500) {
                    player.getInventory().addItem(drink.alcoholDrink("&6Jägerbomb", Color.ORANGE, 500, 7));
                    economy.withdrawPlayer(player, 500);
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
        inventory.setItem(10, createDrink.alcoholDrink("&6Corona Extra", Color.ORANGE, 70.00, 4.6));
        inventory.setItem(11, createDrink.alcoholDrink("&6Michelob Ultra", Color.ORANGE, 60.00, 4.2));
        inventory.setItem(12, createDrink.alcoholDrink("&6Bud Light Plantinum", Color.ORANGE, 80.00, 6));
        inventory.setItem(13, createDrink.alcoholDrink("&6Coors Light", Color.ORANGE, 55.00, 4.2));
        inventory.setItem(14, createDrink.alcoholDrink("&6Budweiser", Color.ORANGE, 50.00, 5));
        inventory.setItem(15, createDrink.alcoholDrink("&6Heineken", Color.ORANGE, 70.00, 5));
        inventory.setItem(16, createDrink.alcoholDrink("&6Guiness", Color.ORANGE, 90.00, 4.2));
        inventory.setItem(17, Items.blackStainedGlass());
        //third row
        inventory.setItem(18, Items.blackStainedGlass());
        inventory.setItem(19, createDrink.alcoholDrink("&cAlabama Slammer", Color.RED, 300.00, 12.5));
        inventory.setItem(20, createDrink.alcoholDrink("&eLemon Drop", Color.YELLOW, 700.00, 6));
        inventory.setItem(21, createDrink.alcoholDrink("&aMelon Ball", Color.LIME, 699.00, 17));
        inventory.setItem(22, createDrink.alcoholDrink("&fKamikaze", Color.WHITE, 807.00, 25));
        inventory.setItem(23, createDrink.alcoholDrink("&4Washington Apple", Color.MAROON, 554.00, 16));
        inventory.setItem(24, createDrink.alcoholDrink("&eVegas Bomb", Color.YELLOW, 525, 11));
        inventory.setItem(25, createDrink.alcoholDrink("&6Jägerbomb", Color.ORANGE, 500, 7));
        inventory.setItem(26, Items.blackStainedGlass());
        //fourth row
        inventory.setItem(27, Items.blackStainedGlass());
        inventory.setItem(28, Items.blackStainedGlass());
        inventory.setItem(29, Items.blackStainedGlass());
        inventory.setItem(30, Items.blackStainedGlass());
        inventory.setItem(31, Items.blackStainedGlass());
        inventory.setItem(32, Items.blackStainedGlass());
        inventory.setItem(33, Items.blackStainedGlass());
        inventory.setItem(34, Items.blackStainedGlass());
        inventory.setItem(35, Items.blackStainedGlass());
    }


}
