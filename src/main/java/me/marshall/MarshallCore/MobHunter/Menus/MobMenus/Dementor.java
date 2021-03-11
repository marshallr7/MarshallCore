package me.marshall.MarshallCore.MobHunter.Menus.MobMenus;

import me.marshall.MarshallCore.MenuSystem.Items;
import me.marshall.MarshallCore.MenuSystem.Menu;
import me.marshall.MarshallCore.MenuSystem.PlayerMenuUtility;
import org.bukkit.event.inventory.InventoryClickEvent;

public class Dementor extends Menu {

    public Dementor(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Dementor";
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
        inventory.setItem(10, Items.blackStainedGlass());
        String[] dementorTierOne = {"test", "test1", "test3"};
        inventory.setItem(10, Items.mobHunterSkull("http://textures.minecraft.net/texture/ba4e9a4accacc51a7cd21a16b3fd8863ff3a89ae544489315b8d35d1402f69b", "&cDementor", dementorTierOne));





        inventory.setItem(16, Items.blackStainedGlass());
        inventory.setItem(17, Items.blackStainedGlass());
        //third row
        inventory.setItem(18, Items.blackStainedGlass());
        inventory.setItem(26, Items.blackStainedGlass());
        inventory.setItem(27, Items.blackStainedGlass());
        inventory.setItem(22, Items.blackStainedGlass());
        inventory.setItem(23, Items.blackStainedGlass());
        inventory.setItem(24, Items.blackStainedGlass());
        inventory.setItem(25, Items.blackStainedGlass());
        inventory.setItem(26, Items.blackStainedGlass());
        inventory.setItem(27, Items.blackStainedGlass());
    }
}
