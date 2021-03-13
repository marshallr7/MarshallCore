package me.marshall.MarshallCore.MobHunter.Menus.MobMenus;

import me.marshall.MarshallCore.MenuSystem.Items;
import me.marshall.MarshallCore.MenuSystem.Menu;
import me.marshall.MarshallCore.MenuSystem.PlayerMenuUtility;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ValkyrieMenu extends Menu {

    public ValkyrieMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Valkyrie Contracts";
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
        String[] valkyrieTierOne = {"test", "test1", "test3"};
        inventory.setItem(11, Items.mobHunterSkull("http://textures.minecraft.net/texture/376ed41af9553515a1e858f0216f6b2863c1bde87f37f19846737eae7359db05", "&4Valkyrie", valkyrieTierOne));





        inventory.setItem(16, Items.blackStainedGlass());
        inventory.setItem(17, Items.blackStainedGlass());
        //third row
        inventory.setItem(18, Items.blackStainedGlass());
        inventory.setItem(19, Items.blackStainedGlass());
        inventory.setItem(20, Items.blackStainedGlass());
        inventory.setItem(21, Items.blackStainedGlass());
        inventory.setItem(22, Items.blackStainedGlass());
        inventory.setItem(23, Items.blackStainedGlass());
        inventory.setItem(24, Items.blackStainedGlass());
        inventory.setItem(25, Items.blackStainedGlass());
        inventory.setItem(26, Items.blackStainedGlass());
        //FOURTH ROW
        inventory.setItem(27, Items.blackStainedGlass());
        inventory.setItem(29, Items.blackStainedGlass());
        inventory.setItem(30, Items.blackStainedGlass());
        inventory.setItem(32, Items.blackStainedGlass());
        inventory.setItem(33, Items.blackStainedGlass());
        inventory.setItem(35, Items.blackStainedGlass());
        //FIFTH ROW
        inventory.setItem(36, Items.blackStainedGlass());
        inventory.setItem(37, Items.blackStainedGlass());
        inventory.setItem(38, Items.blackStainedGlass());
        inventory.setItem(39, Items.blackStainedGlass());
        inventory.setItem(40, Items.blackStainedGlass());
        inventory.setItem(41, Items.blackStainedGlass());
        inventory.setItem(42, Items.blackStainedGlass());
        inventory.setItem(43, Items.blackStainedGlass());
        inventory.setItem(44, Items.blackStainedGlass());
    }
}
