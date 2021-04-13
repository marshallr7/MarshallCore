package me.marshall.MarshallCore;

import me.marshall.MarshallCore.Bar.Commands.BarCommand;
import me.marshall.MarshallCore.Bar.Commands.GambleCommand;
import me.marshall.MarshallCore.Bar.Listeners.BarListener;
import me.marshall.MarshallCore.Bar.Listeners.GambleListener;
import me.marshall.MarshallCore.Cosmetics.Modifiers.NickCommands;
import me.marshall.MarshallCore.Cosmetics.Modifiers.NickListener;
import me.marshall.MarshallCore.Cosmetics.Modifiers.PrefixCommands;
import me.marshall.MarshallCore.Cosmetics.Modifiers.PrefixListener;
import me.marshall.MarshallCore.Currency.GemsCommands;
import me.marshall.MarshallCore.MenuSystem.Listeners.MenuListener;
import me.marshall.MarshallCore.MenuSystem.PlayerMenuUtility;
import me.marshall.MarshallCore.MobHunter.Commands.MobHunterCommand;
import me.marshall.MarshallCore.MobHunter.Commands.MobHunterNPC;
import me.marshall.MarshallCore.MobHunter.Listeners.MobHunterListener;
import me.marshall.MarshallCore.MobHunter.Placeholder;
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
import java.util.UUID;

public final class Core extends JavaPlugin {

    private static final HashMap<Player, PlayerMenuUtility> playerMenuUtilityMap = new HashMap<>();
    private static Economy econ = null;
    private static Core plugin;

    private File playerDataFile;
    private FileConfiguration playerConfig;

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
        //DIRECTORIES
        File dataFolder = plugin.getDataFolder();
        if (!dataFolder.exists()) {
            dataFolder.mkdir();
        }
        File playerDataFolder = new File(dataFolder + "/PlayerData");
        if (!playerDataFolder.exists()) {
            playerDataFolder.mkdir();
            System.out.println("§8[§dMarshallCore§8] §aPlayer data folder created.");
        }

        // CONFIGS
        plugin.saveDefaultConfig();
        createMobHunterConfig();

        //PLACEHOLDERS
        new Placeholder().register();

        //BASE LISTENER
        getServer().getPluginManager().registerEvents(new BaseListeners(), this);
        //MENU LISTENER
        getServer().getPluginManager().registerEvents(new MenuListener(), this);
        // BAR
        if (plugin.getConfig().getBoolean("bar")) {
            getCommand("bar").setExecutor(new BarCommand());
            getServer().getPluginManager().registerEvents(new BarListener(), this);
            Bukkit.getConsoleSender().sendRawMessage("§8[§dMarshallCore§8] §aBar Enabled");
        } else {
            Bukkit.getConsoleSender().sendRawMessage("§8[§dMarshallCore§8] §cBar is set to disabled in the config and will not load.");
        }
        // BAR GAMBLE
        if (plugin.getConfig().getBoolean("bargamble")) {
            getCommand("bargamble").setExecutor(new GambleCommand());
            getServer().getPluginManager().registerEvents(new GambleListener(), this);
            Bukkit.getConsoleSender().sendRawMessage("§8[§dMarshallCore§8] §aBar Gamble Enabled");
        } else {
            Bukkit.getConsoleSender().sendRawMessage("§8[§dMarshallCore§8] §cBar Gamble is set to disabled in the config and will not load.");
        }
        //COSMETICS
        if (plugin.getConfig().getBoolean("cosmetics")) {
            getCommand("nickitem").setExecutor(new NickCommands());
            getCommand("prefixitem").setExecutor(new PrefixCommands());
            getServer().getPluginManager().registerEvents(new PrefixListener(), this);
            getServer().getPluginManager().registerEvents(new NickListener(), this);
            Bukkit.getConsoleSender().sendRawMessage("§8[§dMarshallCore§8] §aCosmetics Enabled");
        } else {
            Bukkit.getConsoleSender().sendRawMessage("§8[§dMarshallCore§8] §cCosmetics are set to disabled in the config and will not load.");
        }
        //CURRENCY
        if (plugin.getConfig().getBoolean("currency")) {
            getCommand("gems").setExecutor(new GemsCommands());
            Bukkit.getConsoleSender().sendRawMessage("§8[§dMarshallCore§8] §aCurrency Enabled");
        } else {
            Bukkit.getConsoleSender().sendRawMessage("§8[§dMarshallCore§8] §cCurrent is set to disabled in the config and will not load.");
        }
        // MOB HUNTER
        if (plugin.getConfig().getBoolean("mobhunter")) {
            getCommand("mobhunter").setExecutor(new MobHunterCommand());
            getServer().getPluginManager().registerEvents(new MobHunterListener(), this);
            getCommand("mobhunternpc").setExecutor(new MobHunterNPC());
            Bukkit.getConsoleSender().sendRawMessage("§8[§dMarshallCore§8] §aMob Hunter Enabled");
        } else {
            Bukkit.getConsoleSender().sendRawMessage("§8[§dMarshallCore§8] §cMob Hunter is set to disabled in the config and will not load.");
        }






        //Vault Check
        if (!setupEconomy()) {
            System.out.println("§8[§dMarshallCore§8] No economy plugin found. Disabling Vault.");
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


    public FileConfiguration getMobHunterConfig() {
        return this.customMobHunterConfig;
    }

    private void createMobHunterConfig() {
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

    public FileConfiguration getPlayerFile(UUID playerUUID) {
        File file = new File(getDataFolder() + "/PlayerData", playerUUID + ".yml");
        FileConfiguration fileConfig = new YamlConfiguration();
        try {
            fileConfig.load(file);
            return fileConfig;
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
        return fileConfig;
    }

    public void updatePlayerFile(UUID playerUUID, String branch, int value) {
        File file = new File(getDataFolder() + "/PlayerData", playerUUID + ".yml");
        FileConfiguration fileConfig = getPlayerFile(playerUUID);
        fileConfig.set(branch, value);
        try {
            fileConfig.save(file);
        } catch (IOException e) {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&cUnable to save" + playerUUID + ".yml"));
        }


    }

    public void createCustomConfig(UUID playerUUID, String playerName) throws IOException {
        playerDataFile = new File(getDataFolder() + "/PlayerData", playerUUID + ".yml");
        if (!playerDataFile.exists()) {
            playerDataFile.getParentFile().mkdirs();
            playerDataFile.createNewFile();
            Bukkit.getServer().getConsoleSender().sendRawMessage(ChatColor.translateAlternateColorCodes('&', "&2Player data file created for: &f" + playerName));
        }
        playerConfig = new YamlConfiguration();
        playerConfig.set("Gems", 0);
        playerConfig.set("MobHunter.ValkyrieExperience", 0);
        playerConfig.set("MobHunter.OdinExperience", 0);
        playerConfig.set("MobHunter.YmirExperience", 0);
        playerConfig.set("MobHunter.DraugrExperience", 0);
        playerConfig.set("MobHunter.LokiExperience", 0);

        try {
            playerConfig.load(playerDataFile);
            Bukkit.getServer().getConsoleSender().sendRawMessage(ChatColor.translateAlternateColorCodes('&', "&2Successfully loaded config for: &f" + playerName));
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
        playerConfig.save(playerDataFile);
    }
}
