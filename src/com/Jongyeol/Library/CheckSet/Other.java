package com.Jongyeol.Library.CheckSet;

import com.Jongyeol.Library.Main;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Other {
    public static boolean playerCheck(Player player) {
        return player != null;
    }
    public static OfflinePlayer getOfflinePlayer(String name){
        try {
            return Bukkit.getOfflinePlayer(UUID.fromString(Main.main.getConfig().getString("Player." + name.toLowerCase())));
        } catch (IllegalArgumentException | NullPointerException e){
            return null;
        }
    }
    public static List<String> getOfflinePlayersName(){
        return Main.main.getConfig().getStringList("Players");
    }
    public static List<OfflinePlayer> getOfflinePlayers(){
        List<OfflinePlayer> players = new ArrayList<>();
        for(String playerName : getOfflinePlayersName()){
            players.add(getOfflinePlayer(playerName));
        }
        return players;
    }
}
