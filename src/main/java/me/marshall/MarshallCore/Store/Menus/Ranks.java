package me.marshall.MarshallCore.Store.Menus;

import me.marshall.MarshallCore.MenuSystem.Items;
import me.marshall.MarshallCore.MenuSystem.Menu;
import me.marshall.MarshallCore.MenuSystem.PlayerMenuUtility;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;

public class Ranks extends Menu {

    public Ranks(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Rank Menu";
    }

    @Override
    public int getSlots() {
        return 9 * 3;
    }

    @Override
    public void handleMenu(InventoryClickEvent event) {

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
        inventory.setItem(9, Items.blackStainedGlass());

        inventory.setItem(10, Items.storeItem(Material.ENDER_CHEST, "&bLord", 1));
        inventory.setItem(11, Items.storeItem(Material.ENDER_CHEST, "&6Outlaw", 1));
        inventory.setItem(12, Items.storeItem(Material.ENDER_CHEST, "&r&2Dealer", 1));
        inventory.setItem(13, Items.blackStainedGlass());
        inventory.setItem(14, Items.storeItem(Material.ENDER_CHEST, "&3H&7aw&fker", 1));
        inventory.setItem(15, Items.storeItem(Material.ENDER_CHEST, "&fR&7aid&8er", 1));
        inventory.setItem(16, Items.storeItem(Material.ENDER_CHEST, "&6&lH&7&le&f&lro", 1));
        inventory.setItem(17, Items.blackStainedGlass());
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
