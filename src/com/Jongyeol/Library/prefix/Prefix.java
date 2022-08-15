package com.Jongyeol.Library.prefix;

import com.Jongyeol.Library.Main;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.event.user.UserDataRecalculateEvent;
import net.luckperms.api.event.user.track.UserPromoteEvent;
import net.luckperms.api.model.group.Group;
import net.luckperms.api.model.user.User;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Prefix {
    private static boolean luckperms;

    private static LuckPerms luckPerms;
    public static String getPrefix(Player player) {
        try {
            return parsingPrefix(getPrimaryGroup(player).getCachedData().getMetaData().getPrefix());
        } catch (NullPointerException e){
            return "";
        }
    }
    public static String getPrefix(OfflinePlayer player) {
        try {
            return parsingPrefix(getPrimaryGroup(player).getCachedData().getMetaData().getPrefix());
        } catch (NullPointerException e){
            return "";
        }
    }
    public Prefix() {
        luckPerms = LuckPermsProvider.get();
        luckPerms.getEventBus().subscribe(UserPromoteEvent.class, e -> onUpdateEvent(e.getUser()));
        luckPerms.getEventBus().subscribe(UserDataRecalculateEvent.class, e -> onUpdateEvent(e.getUser()));
    }
    private void onUpdateEvent(User user){
        final UUID uuid = user.getUniqueId();
        Main.main.getConfig().set("Group." + user.getUniqueId(), user.getPrimaryGroup());
    }
    private static String parsingPrefix(String st){
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
    private static Group getPrimaryGroup(Player player) {
        return luckPerms.getGroupManager().getGroup(getGroupName(player));
    }
    private static Group getPrimaryGroup(OfflinePlayer player) {
        return luckPerms.getGroupManager().getGroup(getGroupName(player));
    }
    public static String getGroupName(Player player) {
        return luckPerms.getUserManager().getUser(player.getUniqueId()).getPrimaryGroup();
    }
    public static String getGroupName(OfflinePlayer player) {
        return Main.main.getConfig().getString("Group." + player.getUniqueId());
    }
    public static boolean Prefixset(Player player) {
        return getPrimaryGroup(player).getCachedData().getMetaData().getPrefix() != null && luckperms;
    }
    public static boolean Prefixset(OfflinePlayer player) {
        return getPrimaryGroup(player).getCachedData().getMetaData().getPrefix() != null && luckperms;
    }
    public static void CheckPlugin(){
        luckperms = Bukkit.getPluginManager().getPlugin("LuckPerms") != null;
    }
}
