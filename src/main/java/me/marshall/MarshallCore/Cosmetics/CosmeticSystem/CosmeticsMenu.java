package me.marshall.MarshallCore.Cosmetics.CosmeticSystem;

import me.marshall.MarshallCore.MenuSystem.Items;
import me.marshall.MarshallCore.MenuSystem.Menu;
import me.marshall.MarshallCore.MenuSystem.PlayerMenuUtility;
import org.bukkit.event.inventory.InventoryClickEvent;

public class CosmeticsMenu extends Menu {

    public CosmeticsMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Cosmetic Shop";
    }

    @Override
    public int getSlots() {
        return 9 * 6;
    }

    @Override
    public void handleMenu(InventoryClickEvent event) {

    }

    @Override
    public void setMenuItems() {
        Items.customDataValueItem();
        for (int i = 0; i < 54; i++) {
            if (i == 11 | i == 20 || i == 21 || i == 23 || i == 24 || i == 29 || i == 30) {

            } else {
                inventory.setItem(i, Items.blackStainedGlass());
            }

        }
    }
}
