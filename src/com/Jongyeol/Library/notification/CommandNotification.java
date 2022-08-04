package com.Jongyeol.Library.notification;

import com.Jongyeol.Library.prefix.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandNotification {
    public static void CommandNoti(String Permission, String String, CommandSender Sender) {
        String sender = "";
        String sendern = "";
        if(Sender instanceof Player) {
            sender = Sender.getName();
            sendern = Sender.getName();
            if (Prefix.Prefixset((Player) Sender)) { sender = Prefix.getPrefix((Player) Sender) + " " + Sender.getName(); }
        } else {
            sender = "Server";
        }
        for(Player player : Bukkit.getOnlinePlayers()){
            if(player.hasPermission(Permission)){
                if(player.getName() != sendern){
                    player.sendMessage(ChatColor.GRAY + "[" + sender + ChatColor.GRAY + ": " + String + "]");
                }
            }
        }
        if(Sender instanceof Player) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "[" + sender + ChatColor.GRAY + ": " + String + "]");
        }
    }
}
