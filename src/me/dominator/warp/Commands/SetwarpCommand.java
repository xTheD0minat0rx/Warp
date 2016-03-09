package me.dominator.warp.Commands;

import me.dominator.warp.SettingsManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

//
// Created by Dominator on 3/9/2016
//
public class SetwarpCommand implements CommandExecutor {

    SettingsManager settings = SettingsManager.getInstance();



    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
        if(!sender.hasPermission("warp.setwarp")){
            sender.sendMessage(ChatColor.RED + "No permission.");
            return true;
        }
        if(args.length == 0){
            sender.sendMessage(ChatColor.RED + "/setwarp <Name>");
            return true;
        }

        Player p = (Player)sender;


        settings.getConfig().set("warps." + args[0].toLowerCase() + ".world", p.getLocation().getWorld().getName());
        settings.getConfig().set("warps." + args[0].toLowerCase() + ".x", p.getLocation().getX());
        settings.getConfig().set("warps." + args[0].toLowerCase() + ".y", p.getLocation().getY());
        settings.getConfig().set("warps." + args[0].toLowerCase() + ".z", p.getLocation().getZ());

        //TODO: Add a pitch and yaw feature

        sender.sendMessage(ChatColor.RED + "Set warp " + args[0]);
        return true;
    }

}
