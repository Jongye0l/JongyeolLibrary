package com.Jongyeol.Library;

import com.Jongyeol.Library.prefix.Prefix;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;

public class EventListener implements Listener {
    private FileConfiguration config;
    private Main main;
    @EventHandler
    public void OnJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if(!Main.main.getConfig().contains("Player." + player.getName().toLowerCase())){
            List<String> list = config.getStringList("Players");
            list.add(player.getName());
            config.set("Players", list);
        }
        config.set("Player." + player.getName().toLowerCase(), player.getUniqueId().toString());
        config.set("Group." + player.getUniqueId(), Prefix.getGroupName(player));
        main.saveConfig();
    }
    public EventListener(Main main){
        this.main = main;
        this.config = main.getConfig();;
    }
}
