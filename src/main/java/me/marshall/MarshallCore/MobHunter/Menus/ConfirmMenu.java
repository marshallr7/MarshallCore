package me.marshall.MarshallCore.MobHunter.Menus;

import me.marshall.MarshallCore.Core;
import me.marshall.MarshallCore.MenuSystem.Items;
import me.marshall.MarshallCore.MenuSystem.Menu;
import me.marshall.MarshallCore.MenuSystem.PlayerMenuUtility;
import me.marshall.MarshallCore.MobHunter.MobHunter;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.UUID;

public class ConfirmMenu extends Menu {
    public ConfirmMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Confirm Purchase";
    }

    @Override
    public int getSlots() {
        return 9*3;
    }

    @Override
    public void handleMenu(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        UUID playerUUID = player.getUniqueId();
        Economy econ = Core.getEconomy();
        switch (event.getCurrentItem().getType()) {
            case LIME_WOOL:
                if (econ.getBalance(player) >= MobHunter.getAttemptedContractPurchase(playerUUID)) {
                    MobHunter.removePlayer(playerUUID);
                    // START CONTRACT HASHMAP
                    econ.withdrawPlayer(player, MobHunter.getAttemptedContractPurchase(playerUUID));
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&2t&fHunter&7] &aContract successfully started"));
                    player.closeInventory();
                    break;
                }
                player.closeInventory();
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&2t&fHunter&7] &cYou can not afford this contract"));
                break;
            case RED_WOOL:
                player.closeInventory();
                break;
        }
    }

    @Override
    public void setMenuItems() {
        inventory.setItem(0, Items.blackStainedGlass());
        inventory.setItem(1, Items.blackStainedGlass());
        inventory.setItem(2, Items.blackStainedGlass());
        inventory.setItem(3, Items.blackStainedGlass());
        inventory.setItem(4, Items.blackStainedGlass());
        inventory.setItem(5, Items.blackStainedGlass());
        inventory.setItem(6, Items.blackStainedGlass());
        inventory.setItem(7, Items.blackStainedGlass());
        inventory.setItem(8, Items.blackStainedGlass());

        //ROW TWO
        inventory.setItem(9, Items.blackStainedGlass());
        inventory.setItem(10, Items.blackStainedGlass());
        //CONFIRM ITEM
        inventory.setItem(11, Items.confirmItem(playerMenuUtility.getOwner().getUniqueId()));
        inventory.setItem(12, Items.blackStainedGlass());
        inventory.setItem(13, Items.blackStainedGlass());
        inventory.setItem(14, Items.blackStainedGlass());
        //CANCEL ITEM
        inventory.setItem(15, Items.cancelItem());
        inventory.setItem(16, Items.blackStainedGlass());
        inventory.setItem(17, Items.blackStainedGlass());

        //ROW THREE
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
