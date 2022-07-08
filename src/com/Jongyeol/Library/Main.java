package com.Jongyeol.Library;

import com.Jongyeol.Library.CheckSet.CustomBoolean;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import com.Jongyeol.Library.notification.madeby;

public class Main extends JavaPlugin {
    @Override
    public void onEnable(){
        BukkitTask madeby = new madeby().runTaskTimer(this, 0L, 54000L);
        new CustomBoolean();
    }
    @Override
    public void onDisable(){

    }
}
