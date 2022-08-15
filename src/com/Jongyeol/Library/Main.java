package com.Jongyeol.Library;

import com.Jongyeol.Library.CheckSet.CustomBoolean;
import com.Jongyeol.Library.prefix.Prefix;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import com.Jongyeol.Library.notification.madeby;

public class Main extends JavaPlugin {
    public static Main main;
    @Override
    public void onEnable(){
        BukkitTask madeby = new madeby().runTaskTimer(this, 0L, 54000L);
        new CustomBoolean();
        main = this;
        Prefix.CheckPlugin();
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new EventListener(this), this);
        new Prefix();
    }
}
