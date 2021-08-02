package com.tozmic.tozmicmob.commands;

import com.tozmic.tozmicmob.models.PolarMain;
import net.minecraft.server.v1_16_R3.EntityPolarBear;
import net.minecraft.server.v1_16_R3.WorldServer;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.PolarBear;
import org.bukkit.event.EventHandler;


public class author implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("tozmicmob") || label.equalsIgnoreCase("tozmic")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&l(!) &7A plugin by &b&oTozmic&7."));
                return true;
            }

        }
        return false;

    }
}