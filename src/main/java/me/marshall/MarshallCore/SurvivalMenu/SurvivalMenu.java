package me.marshall.MarshallCore.SurvivalMenu;

import me.marshall.MarshallCore.MenuSystem.Items;
import me.marshall.MarshallCore.MenuSystem.Menu;
import me.marshall.MarshallCore.MenuSystem.PlayerMenuUtility;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

public class SurvivalMenu extends Menu {
    public SurvivalMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Survival Menu";
    }

    @Override
    public int getSlots() {
        return 9 * 6;
    }

    @Override
    public void handleMenu(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Bukkit.broadcastMessage(event.getRawSlot() + "");
        switch (event.getRawSlot()) {
            case 13:
                Bukkit.broadcastMessage(playerMenuUtility.getOwner().getUniqueId() + "");
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

        //SECOND ROW
        inventory.setItem(9, Items.blackStainedGlass());
        inventory.setItem(10, Items.blackStainedGlass());
        inventory.setItem(11, Items.blackStainedGlass());
        inventory.setItem(12, Items.blackStainedGlass());
        inventory.setItem(13, Items.playerHead(playerMenuUtility.getOwner().getUniqueId()));
        inventory.setItem(14, Items.blackStainedGlass());
        inventory.setItem(15, Items.blackStainedGlass());
        inventory.setItem(16, Items.blackStainedGlass());
        inventory.setItem(17, Items.blackStainedGlass());

        //THIRD ROW
        inventory.setItem(18, Items.blackStainedGlass());
        // 19 skills
        //20 ranks
        // 21 toolbelt
        // 22 quest log
        // 23 settings
        // 24 ender chest
        // 25 homes
        inventory.setItem(26, Items.blackStainedGlass());

        //FOURTH ROW
        inventory.setItem(27, Items.blackStainedGlass());
        inventory.setItem(28, Items.blackStainedGlass());
        inventory.setItem(29, Items.blackStainedGlass());
        // 30 bestiary
        // 31 crafting bench
        // 32 cosmetics
        inventory.setItem(33, Items.blackStainedGlass());
        inventory.setItem(34, Items.blackStainedGlass());
        inventory.setItem(35, Items.blackStainedGlass());

        // FIFTH ROW
        inventory.setItem(36, Items.blackStainedGlass());
        inventory.setItem(37, Items.blackStainedGlass());
        inventory.setItem(38, Items.blackStainedGlass());
        inventory.setItem(39, Items.blackStainedGlass());
        inventory.setItem(40, Items.blackStainedGlass());
        inventory.setItem(41, Items.blackStainedGlass());
        inventory.setItem(42, Items.blackStainedGlass());
        inventory.setItem(43, Items.blackStainedGlass());
        inventory.setItem(44, Items.blackStainedGlass());

        // SIXTH ROW
        inventory.setItem(45, Items.blackStainedGlass());
        inventory.setItem(46, Items.blackStainedGlass());
        inventory.setItem(47, Items.blackStainedGlass());
        inventory.setItem(48, Items.blackStainedGlass());
        inventory.setItem(49, Items.closeItem());
        inventory.setItem(50, Items.blackStainedGlass());
        inventory.setItem(51, Items.blackStainedGlass());
        inventory.setItem(52, Items.blackStainedGlass());
        inventory.setItem(53, Items.blackStainedGlass());
    }
}
