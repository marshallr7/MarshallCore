package me.marshall.MarshallCore.MobHunter.Menus;

import me.marshall.MarshallCore.Core;
import me.marshall.MarshallCore.MenuSystem.Items;
import me.marshall.MarshallCore.MenuSystem.Menu;
import me.marshall.MarshallCore.MenuSystem.PlayerMenuUtility;
import me.marshall.MarshallCore.MobHunter.Menus.MobMenus.*;
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
            case "§4§lValkyrie":
                ValkyrieMenu valkyrieMenu = new ValkyrieMenu(Core.getPlayerMenuUtility(player));
                valkyrieMenu.open();
                break;
            case "§8§lOdin":
                OdinMenu odinMenu = new OdinMenu(Core.getPlayerMenuUtility(player));
                odinMenu.open();
                break;
            case "§b§lYmir":
                YmirMenu ymirMenu = new YmirMenu(Core.getPlayerMenuUtility(player));
                ymirMenu.open();
                break;
            case "§6§lDraugr":
                DraugrMenu draugrMenu = new DraugrMenu(Core.getPlayerMenuUtility(player));
                draugrMenu.open();
                break;
            case "§f§lNornir":
                NornirMenu nornirMenu = new NornirMenu(Core.getPlayerMenuUtility(player));
                nornirMenu.open();
                break;


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
        inventory.setItem(10, Items.blackStainedGlass());
        //TODO: ADD LORE TO THE MAIN MENU ITEMS
        String[] valkyrieLore = {"&8Instructed to the battlefields", "&8by Odin, selected to be", "&8deciders in life or death.", "&f", "&7Click here to view", "&4Valkyrie &7contracts."};
        inventory.setItem(11, Items.mobHunterSkull("http://textures.minecraft.net/texture/376ed41af9553515a1e858f0216f6b2863c1bde87f37f19846737eae7359db05", "&4&lValkyrie", valkyrieLore));
        String[] odinLore = {"&8Once a noble leader slain by Fenrir", "&8summoned again to reclaim his crown.","&f", "&7Click here to view", "&8Odin &7contracts."};
        inventory.setItem(12, Items.mobHunterSkull("http://textures.minecraft.net/texture/c70413173349cd10e3e574edbefefcf91f4b4843083925e3082a486ff9769975","&8&lOdin", odinLore));
        String[] ymirLore = {"&f", "&7Click here to view", "&bYmir &7contracts."};
        inventory.setItem(13, Items.mobHunterSkull("http://textures.minecraft.net/texture/5043a42a20d7c474df1bd74c3ac8502e427064a7d0111bc8347dc84236888377", "&b&lYmir", ymirLore));
        String[] draugrLore = {"&f", "&7Click here to view", "&6Dragugar &7contracts."};
        inventory.setItem(14, Items.mobHunterSkull("http://textures.minecraft.net/texture/32e2d0ed14c23862666b405aefabc65a57a271e842fda5f4d19e6bc118ce0c94", "&6&lDraugr", draugrLore));
        String[] nornirLore = {"&f", "&7Click here to view", "&fNornir &7contracts."};
        inventory.setItem(15, Items.mobHunterSkull("http://textures.minecraft.net/texture/cc3b8cc35ffe89b134e9db8842d51eff23811a5794b04ed4a6d8ca4c25234a47", "&f&lNornir", nornirLore));
        inventory.setItem(16, Items.blackStainedGlass());
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
