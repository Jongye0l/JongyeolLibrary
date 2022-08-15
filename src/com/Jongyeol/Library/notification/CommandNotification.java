package com.Jongyeol.Library.notification;

import com.Jongyeol.Library.prefix.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandNotification {
    public static void CommandNoti(String Permission, String String, CommandSender Sender) {
        String sender = "";
        if(Sender instanceof Player) {
            try{
                sender = Prefix.getPrefix((Player) Sender) + Sender.getName();
            } catch (NullPointerException e){
                sender = Sender.getName();
            }
        } else {
            sender = "Server";
        }
        for(Player player : Bukkit.getOnlinePlayers()){
            if(player.hasPermission(Permission)){
                if(!player.equals(Sender)){
                    player.sendMessage(ChatColor.GRAY + "[" + sender + ChatColor.GRAY + ": " + String + "]");
                }
            }
        }
        if(Sender instanceof Player) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "[" + sender + ChatColor.GRAY + ": " + String + "]");
        }
    }
}
