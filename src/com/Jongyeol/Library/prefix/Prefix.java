package com.Jongyeol.Library.prefix;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.group.Group;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Prefix {
    private static boolean luckperms;

    private static LuckPerms luckPerms;
    public static String getPrefix(Player player) {
        if(Prefixset(player)){
            String st = getPrimaryGroup(player).getCachedData().getMetaData().getPrefix();
            String prefix = "";
            String[] pre = st.split("");
            for(int i = 0; i < pre.length; i++){
                if(pre[i].equals("&")) {
                    if (pre.length > i + 1) {
                        if (ChatColor.getByChar(pre[i + 1]) == null) {
                            prefix = prefix + pre[i];
                            continue;
                        }
                    }
                    prefix = prefix + ChatColor.COLOR_CHAR;
                    continue;
                }
                prefix = prefix + pre[i];
            }
            return prefix + " ";
        }
        return "";
    }
    private static Group getPrimaryGroup(Player player) {
        return luckPerms.getGroupManager().getGroup(luckPerms.getUserManager().getUser(player.getUniqueId()).getPrimaryGroup());
    }
    public static boolean Prefixset(Player player) {
        if(luckperms){
            return getPrimaryGroup(player).getCachedData().getMetaData().getPrefix() != null;
        } else {
            return false;
        }
    }
    static {
        luckPerms = LuckPermsProvider.get();
    }
    public static void CheckPlugin(){
        luckperms = Bukkit.getPluginManager().getPlugin("LuckPerms") != null;
    }
}
