package me.marshall.MarshallCore;

import me.marshall.MarshallCore.Bar.Commands.BarCommand;
import me.marshall.MarshallCore.Bar.Listeners.BarListener;
import me.marshall.MarshallCore.Bar.Commands.GambleCommand;
import me.marshall.MarshallCore.Bar.Listeners.GambleListener;
import me.marshall.MarshallCore.MenuSystem.Listeners.MenuListener;
import me.marshall.MarshallCore.MenuSystem.PlayerMenuUtility;
import me.marshall.MarshallCore.MobHunter.Commands.MobHunterCommand;
import me.marshall.MarshallCore.MobHunter.Commands.MobHunterNPC;
import me.marshall.MarshallCore.MobHunter.Listeners.MobHunterListener;
import me.marshall.MarshallCore.MobHunter.Menus.MobHunterMenu;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public final class Core extends JavaPlugin {

    private static final HashMap<Player, PlayerMenuUtility> playerMenuUtilityMap = new HashMap<>();
    private static Economy econ = null;
    private static Core plugin;

    private File customMobHunterFile;
    private FileConfiguration customMobHunterConfig;

    public static Core getInstance() {
        return plugin;
    }

    public static Economy getEconomy() {
        return econ;
    }


    //####################################
    //           ON ENABLE
    //####################################
    @Override
    public void onEnable() {
        plugin = this;
        // CONFIGS
        plugin.saveDefaultConfig();
        createSlayerConfig();

        //MENU LISTENER
        getServer().getPluginManager().registerEvents(new MenuListener(), this);
        // BAR
        if (plugin.getConfig().getBoolean("bar")) {
            getCommand("bar").setExecutor(new BarCommand());
            getServer().getPluginManager().registerEvents(new BarListener(), this);
            Bukkit.getConsoleSender().sendRawMessage("Bar Enabled");
        } else {
            Bukkit.getConsoleSender().sendRawMessage("Bar is set to disabled in the config and will not load.");
        }
        // BAR GAMBLE
        if (plugin.getConfig().getBoolean("bargamble")) {
            getCommand("bargamble").setExecutor(new GambleCommand());
            getServer().getPluginManager().registerEvents(new GambleListener(), this);
            Bukkit.getConsoleSender().sendRawMessage("Bar Gamble Enabled");
        } else {
            Bukkit.getConsoleSender().sendRawMessage("Bar Gamble is set to disabled in the config and will not load.");
        }
        // MOB HUNTER
        if (plugin.getConfig().getBoolean("mobhunter")) {
            getCommand("mobhunter").setExecutor(new MobHunterCommand());
            getServer().getPluginManager().registerEvents(new MobHunterListener(), this);
            getCommand("mobhunternpc").setExecutor(new MobHunterNPC());
            Bukkit.getConsoleSender().sendRawMessage("Mob Hunter Enabled");
        } else {
            Bukkit.getConsoleSender().sendRawMessage("Mob Hunter is set to disabled in the config and will not load.");
        }






        //Vault Check
        if (!setupEconomy()) {
            System.out.println("No economy plugin found. Disabling Vault.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
    }




    @Override
    public void onDisable() {
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


    public FileConfiguration getSlayerConfig() {
        return this.customMobHunterConfig;
    }

    private void createSlayerConfig() {
        customMobHunterFile = new File(getDataFolder(), "/mobhunter.yml");
        if (!customMobHunterFile.exists()) {
            customMobHunterFile.getParentFile().mkdirs();
            saveResource("mobhunter.yml", false);
        }

        customMobHunterConfig = new YamlConfiguration();
        try {
            customMobHunterConfig.load(customMobHunterFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }


}
