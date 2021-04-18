package me.marshall.MarshallCore.MobHunter.Menus.MobMenus;

import me.marshall.MarshallCore.MenuSystem.Menu;
import me.marshall.MarshallCore.MenuSystem.PlayerMenuUtility;
import org.bukkit.event.inventory.InventoryClickEvent;

public class LokiMenu extends Menu {
    public LokiMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Loki Contracts";
    }

    @Override
    public int getSlots() {
        return 9*5;
    }

    @Override
    public void handleMenu(InventoryClickEvent event) {

    }

    @Override
    public void setMenuItems() {

    }
}
