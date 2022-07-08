package com.Jongyeol.Library.CheckSet;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Other {
    public static boolean playerCheck(Player player){
        for (Player player2 : Bukkit.getOnlinePlayers()){
            if(player2.equals(player)){return true;}
        }
        return false;
    }
}
