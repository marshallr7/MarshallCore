package me.marshall.MarshallCore.MobHunter.Menus.MobMenus;

import me.marshall.MarshallCore.MenuSystem.Items;
import me.marshall.MarshallCore.MenuSystem.Menu;
import me.marshall.MarshallCore.MenuSystem.PlayerMenuUtility;
import org.bukkit.event.inventory.InventoryClickEvent;

public class OdinMenu extends Menu {
    public OdinMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Odin Contracts";
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
        // Once a noble leader, slain by Fenrir, summoned again to reclaim his crown.
        String[] odinTierOne = {"&f", "&7click here to view", "&8Odin &7contracts."};
        inventory.setItem(11, Items.mobHunterSkull("http://textures.minecraft.net/texture/c70413173349cd10e3e574edbefefcf91f4b4843083925e3082a486ff9769975","&8Odin", odinTierOne));
    }
}
