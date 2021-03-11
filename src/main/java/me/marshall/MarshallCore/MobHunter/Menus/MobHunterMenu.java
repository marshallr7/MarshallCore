package me.marshall.MarshallCore.MobHunter.Menus;

import me.marshall.MarshallCore.Core;
import me.marshall.MarshallCore.MenuSystem.Items;
import me.marshall.MarshallCore.MenuSystem.Menu;
import me.marshall.MarshallCore.MenuSystem.PlayerMenuUtility;
import me.marshall.MarshallCore.MobHunter.Menus.MobMenus.Dementor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MobHunterMenu extends Menu implements Listener {
    public MobHunterMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Mob Hunter";
    }

    @Override
    public int getSlots() {
        return 9*3;
    }

    @Override
    public void handleMenu(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        switch(event.getCurrentItem().getItemMeta().getDisplayName()) {
            case "&f":
                break;
            case "§cDementor":
                Dementor menu = new Dementor(Core.getPlayerMenuUtility(player));
                menu.open();

        }
    }

    @Override
    public void setMenuItems() {

        //ROW 1
        inventory.setItem(0, Items.blackStainedGlass());
        inventory.setItem(1, Items.blackStainedGlass());
        inventory.setItem(2, Items.blackStainedGlass());
        inventory.setItem(3, Items.blackStainedGlass());
        inventory.setItem(4, Items.blackStainedGlass());
        inventory.setItem(5, Items.blackStainedGlass());
        inventory.setItem(6, Items.blackStainedGlass());
        inventory.setItem(7, Items.blackStainedGlass());
        inventory.setItem(8, Items.blackStainedGlass());
        //ROW 2
        inventory.setItem(9, Items.blackStainedGlass());
        String[] dementorLore = {"&f", "&7Click here to view", "&cDementor &7contracts."};
        inventory.setItem(10, Items.mobHunterSkull("http://textures.minecraft.net/texture/ba4e9a4accacc51a7cd21a16b3fd8863ff3a89ae544489315b8d35d1402f69b", "&cDementor", dementorLore));







        inventory.setItem(17, Items.blackStainedGlass());
        //ROW3
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
