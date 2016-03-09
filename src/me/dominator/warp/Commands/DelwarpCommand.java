package me.dominator.warp.Commands;

import me.dominator.warp.SettingsManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

//
// Created by Dominator on 3/9/2016
//
public class DelwarpCommand implements CommandExecutor {

    SettingsManager settings = SettingsManager.getInstance();

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
        if(!sender.hasPermission("warp.delwarp")){
            sender.sendMessage(ChatColor.RED + "No permission.");
            return true;
        }
        if(args.length == 0){
            sender.sendMessage(ChatColor.RED + "/delwarp <Name>");
            return true;
        }
        if(settings.getConfig().getConfigurationSection("warps." + args[0].toLowerCase()) == null){
            sender.sendMessage(ChatColor.RED + "That warp doesn't exist!");
            return true;
        }

        settings.getConfig().set("warps." + args[0].toLowerCase(), null);
        settings.save();
        sender.sendMessage(ChatColor.RED + "Deleted warp " + args[0]);
        return true;
    }

}
