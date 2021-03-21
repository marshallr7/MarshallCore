package me.marshall.MarshallCore.MobHunter.Menus;

import me.marshall.MarshallCore.MenuSystem.Items;
import me.marshall.MarshallCore.MenuSystem.Menu;
import me.marshall.MarshallCore.MenuSystem.PlayerMenuUtility;
import me.marshall.MarshallCore.MobHunter.MobHunter;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class CancelMenu extends Menu {
    public CancelMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Cancel Contract";
    }

    @Override
    public int getSlots() {
        return 9*3;
    }

    @Override
    public void handleMenu(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getCurrentItem().getType() == Material.BARRIER) {
            MobHunter.removeOnGoingContract(player.getUniqueId());
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&2t&fHunter&7] &cYou have successfully cancelled your contract"));
            player.closeInventory();
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
        inventory.setItem(11, Items.blackStainedGlass());
        inventory.setItem(12, Items.blackStainedGlass());
        inventory.setItem(13, Items.cancelContractItem());
        inventory.setItem(14, Items.blackStainedGlass());
        inventory.setItem(15, Items.blackStainedGlass());
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
