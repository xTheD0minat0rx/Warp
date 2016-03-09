package me.dominator.warp.Commands;

import me.dominator.warp.SettingsManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

//
// Created by Dominator on 3/9/2016
//
public class ReloadCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
        if(!sender.hasPermission("warp.reload")){
            return true;
        }
        sender.sendMessage(ChatColor.RED + "Saving the config...");
        SettingsManager.getInstance().save();
        sender.sendMessage(ChatColor.RED + "Reloading the config...");
        SettingsManager.getInstance().reload();
        sender.sendMessage(ChatColor.RED + "Reloaded the config!");


        return true;
    }

}
