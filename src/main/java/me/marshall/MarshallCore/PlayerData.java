package me.marshall.MarshallCore;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PlayerData {

    private Player player;
    private UUID uuid;
    private Integer exp;
    private Integer level;

    public PlayerData(UUID uuid, int exp, int level) {
        this.player = Bukkit.getPlayer(uuid);
        this.uuid = uuid;
        this.exp = exp;
        this.level = level;
    }
}
