package me.dominator.warp;

import me.dominator.warp.Commands.DelwarpCommand;
import me.dominator.warp.Commands.ReloadCommand;
import me.dominator.warp.Commands.SetwarpCommand;
import me.dominator.warp.Commands.WarpCommand;
import org.bukkit.plugin.java.JavaPlugin;
//
// Created by Dominator on 3/9/2016
//
public class Main extends JavaPlugin {

    SettingsManager settings = SettingsManager.getInstance();

    public void onEnable(){
        settings.setup(this);
        this.getCommand("warp").setExecutor(new WarpCommand(this));
        this.getCommand("setwarp").setExecutor(new SetwarpCommand());
        this.getCommand("warpreload").setExecutor(new ReloadCommand());
        this.getCommand("delwarp").setExecutor(new DelwarpCommand());
    }

}
