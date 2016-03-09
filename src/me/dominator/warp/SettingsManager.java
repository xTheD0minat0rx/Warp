package me.dominator.warp;


import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;

//
// Created by Dominator on 3/9/2016
//
public class SettingsManager {

    private SettingsManager(){}

    public static SettingsManager instance = new SettingsManager();

    public static SettingsManager getInstance(){
        return instance;
    }

    FileConfiguration config;
    File cfile;

    Plugin p;

    public void setup(Plugin p){
        this.p = p;
        config = p.getConfig();
        config.options().copyDefaults(true);
        cfile = new File(p.getDataFolder(), "data.yml");
        save();
    }

    public FileConfiguration getConfig(){
        return config;
    }

    public void reload(){
        YamlConfiguration.loadConfiguration(cfile);
    }

    public void save(){
        try {config.save(cfile);}
        catch(Exception e){ e.printStackTrace();}
    }

}
