package me.marshall.MarshallCore.MenuSystem.Menus;

import me.marshall.MarshallCore.MenuSystem.Menu;
import me.marshall.MarshallCore.MenuSystem.PlayerMenuUtility;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ExampleMenu extends Menu {

    public ExampleMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Example Menu :)";
    }

    @Override
    public int getSlots() {
        return 9;
    }

    @Override
    public void handleMenu(InventoryClickEvent event) {
        switch(event.getCurrentItem().getType()) {
            case BLACK_STAINED_GLASS_PANE:
                break;

            case WET_SPONGE:
                event.getWhoClicked().closeInventory();
                event.getWhoClicked().sendMessage("AAAAAAAA");
                break;
        }
    }

    @Override
    public void setMenuItems() {
        ItemStack blackStainedGlassPane = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
        ItemMeta blackStainedGlassPaneMeta = blackStainedGlassPane.getItemMeta();
        blackStainedGlassPaneMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', " "));
        blackStainedGlassPane.setItemMeta(blackStainedGlassPaneMeta);

        ItemStack testItem = new ItemStack(Material.WET_SPONGE, 1);
        ItemMeta testItemMeta = testItem.getItemMeta();
        testItemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', " "));
        testItem.setItemMeta(testItemMeta);

        inventory.setItem(3, blackStainedGlassPane);
        inventory.setItem(4, testItem);
    }
}
