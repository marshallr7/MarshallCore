package me.marshall.MarshallCore.MobHunter.Menus.MobMenus;

import me.marshall.MarshallCore.Core;
import me.marshall.MarshallCore.MenuSystem.Items;
import me.marshall.MarshallCore.MenuSystem.Menu;
import me.marshall.MarshallCore.MenuSystem.PlayerMenuUtility;
import me.marshall.MarshallCore.MobHunter.Menus.ConfirmMenu;
import me.marshall.MarshallCore.MobHunter.MobHunter;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.UUID;

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
        Player player = (Player) event.getWhoClicked();
        UUID playerUUID = player.getUniqueId();
        ConfirmMenu confirmation = new ConfirmMenu(Core.getPlayerMenuUtility(player));
        switch (event.getCurrentItem().getItemMeta().getDisplayName()) {
            case "§4Wise Valkyrie":
                MobHunter.setAttempt(playerUUID, 10000, "WiseValkyrie");
                confirmation.open();
                break;
            case "§4Zealous Valkyrie":
                MobHunter.setAttempt(playerUUID, 25000, "ZealousValkyrie");
                confirmation.open();
                break;
            case "§4Troublesome Valkyrie":
                MobHunter.setAttempt(playerUUID, 50000, "TroublesomeValkyrie");
                confirmation.open();
                break;
            case "§4Belligerent Valkyrie":
                MobHunter.setAttempt(playerUUID, 75000, "BelligerentValkyrie");
                confirmation.open();
                break;
            case "§4Transcended Valkyrie":
                MobHunter.setAttempt(playerUUID, 100000, "TranscendedValkyrie");
                confirmation.open();
                break;
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
        //second row
        inventory.setItem(9, Items.blackStainedGlass());
        inventory.setItem(10, Items.blackStainedGlass());
        String[] valkyrieTierOne = {"&7Difficulty: Easy", "&f", "&7Health: &cxxxx❤", "&7Damage: &cxx &7", "&f", "&aAbility One", "&7Ability one description", "&f", "&2Reward:", "    &7x Valkyrie Hunter Exp", "    &71x Random Valkyrie Drop"};
        inventory.setItem(11, Items.mobHunterSkull("http://textures.minecraft.net/texture/376ed41af9553515a1e858f0216f6b2863c1bde87f37f19846737eae7359db05", "&4Wise Valkyrie", valkyrieTierOne));
        if (playerMenuUtility.getOwner().hasPermission("mobhunter.valkyrie.tiertwo")) {
            String[] valkyrieTierTwo = {"&7Difficulty: Easy", "&f", "&7Health: &cxxxx❤", "&7Damage: &cxx &7", "&f", "&aAbility One", "&7Ability one description", "&f", "&2Reward:", "    &7x Valkyrie Hunter Exp", "    &71x Random Valkyrie Drop"};
            inventory.setItem(12, Items.mobHunterSkull("http://textures.minecraft.net/texture/376ed41af9553515a1e858f0216f6b2863c1bde87f37f19846737eae7359db05", "&4Zealous Valkyrie", valkyrieTierTwo));
        } else {
            inventory.setItem(12, Items.mobHunterNoPermission());
        }
        if (playerMenuUtility.getOwner().hasPermission("mobhunter.valkyrie.tierthree")) {
            String[] valkyrieTierThree = {"&7Difficulty: Easy", "&f", "&7Health: &cxxxx❤", "&7Damage: &cxx &7", "&f", "&aAbility One", "&7Ability one description", "&f", "&2Reward:", "    &7x Valkyrie Hunter Exp", "    &71x Random Valkyrie Drop"};
            inventory.setItem(13, Items.mobHunterSkull("http://textures.minecraft.net/texture/376ed41af9553515a1e858f0216f6b2863c1bde87f37f19846737eae7359db05", "&4Troublesome Valkyrie", valkyrieTierThree));
        } else {
            inventory.setItem(13, Items.mobHunterNoPermission());
        }
        if (playerMenuUtility.getOwner().hasPermission("mobhunter.valkyrie.tierfour")) {
            String[] valkyrieTierThree = {"&7Difficulty: Easy", "&f", "&7Health: &cxxxx❤", "&7Damage: &cxx &7", "&f", "&aAbility One", "&7Ability one description", "&f", "&2Reward:", "    &7x Valkyrie Hunter Exp", "    &71x Random Valkyrie Drop"};
            inventory.setItem(14, Items.mobHunterSkull("http://textures.minecraft.net/texture/376ed41af9553515a1e858f0216f6b2863c1bde87f37f19846737eae7359db05", "&4Belligerent Valkyrie", valkyrieTierThree));
        } else {
            inventory.setItem(14, Items.mobHunterNoPermission());
        }
        if (playerMenuUtility.getOwner().hasPermission("mobhunter.valkyrie.tierfive")) {
                String[] valkyrieTierFive = {"&7Difficulty: Easy", "&f", "&7Health: &cxxxx❤", "&7Damage: &cxx &7", "&f", "&aAbility One", "&7Ability one description", "&f", "&2Reward:", "    &7x Valkyrie Hunter Exp", "    &71x Random Valkyrie Drop"};
                inventory.setItem(15, Items.mobHunterSkull("http://textures.minecraft.net/texture/376ed41af9553515a1e858f0216f6b2863c1bde87f37f19846737eae7359db05", "&4Transcended Valkyrie", valkyrieTierFive));
        } else {
            inventory.setItem(15, Items.mobHunterNoPermission());
        }




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
        inventory.setItem(26, Items.mobHunterXPItem(playerMenuUtility.getOwner().getUniqueId(), "Valkyrie"));
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
