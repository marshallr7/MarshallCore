package me.marshall.MarshallCore;

import org.bukkit.ChatColor;

public class Utils {

    public static int percentage(int x, int y) {
        return (x / y) * 100;
    }

    public static String percentageBar(int percent) {
        if (percent >= 95) {
            return ChatColor.translateAlternateColorCodes('&', "&a-------------------&f-");
        } else if (percent >= 90) {
            return ChatColor.translateAlternateColorCodes('&', "&a------------------&f--");
        } else if (percent >= 85) {
            return ChatColor.translateAlternateColorCodes('&', "&a-----------------&f---");
        } else if (percent >= 80) {
            return ChatColor.translateAlternateColorCodes('&', "&a----------------&f----");
        } else if (percent >= 75) {
            return ChatColor.translateAlternateColorCodes('&', "&a---------------&f-----");
        } else if (percent >= 70) {
            return ChatColor.translateAlternateColorCodes('&', "&a--------------&f------");
        } else if (percent >= 65) {
            return ChatColor.translateAlternateColorCodes('&', "&a-------------&f-------");
        } else if (percent >= 60) {
            return ChatColor.translateAlternateColorCodes('&', "&a------------&f--------");
        } else if (percent >= 55) {
            return ChatColor.translateAlternateColorCodes('&', "&a-----------&f---------");
        } else if (percent >= 50) {
            return ChatColor.translateAlternateColorCodes('&', "&a----------&f----------");
        } else if (percent >= 45) {
            return ChatColor.translateAlternateColorCodes('&', "&a---------&f-----------");
        } else if (percent >= 40) {
            return ChatColor.translateAlternateColorCodes('&', "&a--------&f------------");
        } else if (percent >= 35) {
            return ChatColor.translateAlternateColorCodes('&', "&a-------&f-------------");
        } else if (percent >= 30) {
            return ChatColor.translateAlternateColorCodes('&', "&a------&f--------------");
        } else if (percent >= 25) {
            return ChatColor.translateAlternateColorCodes('&', "&a-----&f---------------");
        } else if (percent >= 20) {
            return ChatColor.translateAlternateColorCodes('&', "&a----&f----------------");
        } else if (percent >= 15) {
            return ChatColor.translateAlternateColorCodes('&', "&a---&f-----------------");
        } else if (percent >= 10) {
            return ChatColor.translateAlternateColorCodes('&', "&a--&f------------------");
        } else if (percent >= 5) {
            return ChatColor.translateAlternateColorCodes('&', "&a-&f-------------------");
        } else {
            return ChatColor.translateAlternateColorCodes('&', "&f--------------------");
        }
    }
}
