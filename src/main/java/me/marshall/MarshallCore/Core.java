package me.marshall.MarshallCore;

import me.marshall.MarshallCore.Bar.Commands.BarCommand;
import me.marshall.MarshallCore.Bar.Listeners.BarListener;
import me.marshall.MarshallCore.Bar.Commands.GambleCommand;
import me.marshall.MarshallCore.Bar.Listeners.GambleListener;
import me.marshall.MarshallCore.MenuSystem.Commands.ExampleCommand;
import me.marshall.MarshallCore.MenuSystem.Listeners.MenuListener;
import me.marshall.MarshallCore.MenuSystem.PlayerMenuUtility;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class Core extends JavaPlugin {

    private static final HashMap<Player, PlayerMenuUtility> playerMenuUtilityMap = new HashMap<>();
    private static Economy econ = null;
    private static Core plugin;

    public static Core getInstance() {
        return plugin;
    }

    public static Economy getEconomy() {
        return econ;
    }



    @Override
    public void onEnable() {
        plugin = this;

        // EXAMPLE
        getCommand("examplecommand").setExecutor(new ExampleCommand());
        getServer().getPluginManager().registerEvents(new MenuListener(), this);

        //BAR
        getCommand("bar").setExecutor(new BarCommand());
        getServer().getPluginManager().registerEvents(new BarListener(), this);

        //BAR GAMBLE
        getCommand("bargamble").setExecutor(new GambleCommand());
        getServer().getPluginManager().registerEvents(new GambleListener(), this);


        //Vault Check
        if (!setupEconomy()) {
            System.out.println("No economy plugin found. Disabling Vault.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static PlayerMenuUtility getPlayerMenuUtility(Player player) {
        PlayerMenuUtility playerMenuUtility;

        if (playerMenuUtilityMap.containsKey(player)) {
            return playerMenuUtilityMap.get(player);
        } else {
            playerMenuUtility = new PlayerMenuUtility(player);
            playerMenuUtilityMap.put(player, playerMenuUtility);
            return playerMenuUtility;
        }
    }


    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return true;
    }



}
