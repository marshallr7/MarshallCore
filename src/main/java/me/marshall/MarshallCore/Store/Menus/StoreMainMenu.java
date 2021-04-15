package me.marshall.MarshallCore.Store.Menus;

import me.marshall.MarshallCore.Core;
import me.marshall.MarshallCore.MenuSystem.Items;
import me.marshall.MarshallCore.MenuSystem.Menu;
import me.marshall.MarshallCore.MenuSystem.PlayerMenuUtility;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

public class StoreMainMenu extends Menu {

    public StoreMainMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Gem Shop";
    }

    @Override
    public int getSlots() {
        return 27;
    }

    @Override
    public void handleMenu(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        switch (event.getCurrentItem().getItemMeta().getDisplayName()) {
            case "Crate Keys":
                break;
            case "§2§lRanks":
                Ranks ranks = new Ranks(Core.getPlayerMenuUtility(player));
                ranks.open();
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
        inventory.setItem(9, Items.blackStainedGlass());
        inventory.setItem(10, Items.blackStainedGlass());
        inventory.setItem(11, Items.storeItem(Material.TRIPWIRE_HOOK, "Crate Keys", 1));
        inventory.setItem(12, Items.storeItem(Material.GLOWSTONE_DUST, "Consumables", 1));
        inventory.setItem(13, Items.storeItem(Material.ENDER_CHEST, "Ranks", 1));
        inventory.setItem(14, Items.storeItem(Material.NAME_TAG, "Miscellaneous", 1));
        inventory.setItem(15, Items.storeItem(Material.FIREWORK_ROCKET, "Cosmetics", 1));
        inventory.setItem(16, Items.blackStainedGlass());
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
