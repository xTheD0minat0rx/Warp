package me.dominator.warp.Commands;

import me.dominator.warp.Main;
import me.dominator.warp.SettingsManager;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

//
// Created by Dominator on 3/9/2016
//
public class WarpCommand implements CommandExecutor {

    private Main plugin;
    public WarpCommand(Main instance){
        plugin = instance;
    }

    SettingsManager settings = SettingsManager.getInstance();

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
        if(!sender.hasPermission("warp.warp")){
            sender.sendMessage(ChatColor.RED + "No permission.");
            return true;
        }
        if(args.length == 0){
            sender.sendMessage(ChatColor.RED  + "/warp <Name>");
            return true;
        }
        if(settings.getConfig().getConfigurationSection("warps." + args[0]) == null){
            sender.sendMessage(ChatColor.RED + "That warp doesn't exist!");
            return true;
        }
        Player p = (Player)sender;
        World w = plugin.getServer().getWorld(settings.getConfig().getString("warps." + args[0].toLowerCase() + ".world"));
        double x = settings.getConfig().getDouble("warps." + args[0].toLowerCase() + ".x");
        double y = settings.getConfig().getDouble("warps." + args[0].toLowerCase() + ".y");
        double z = settings.getConfig().getDouble("warps." + args[0].toLowerCase() + ".z");

        p.teleport(new Location(w, x, y, z));

        p.sendMessage(ChatColor.GREEN + "Teleported to " + args[0] + "!");
        return true;
    }

}
