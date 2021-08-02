package com.tozmic.tozmicmob.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import com.tozmic.tozmicmob.TozmicMob;
import com.tozmic.tozmicmob.utils.text.Localizer;
import com.tozmic.tozmicmob.listeners.FreezeListener;


public class unfreeze implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length != 1) {
            sender.sendMessage(Localizer.getLocalizedCommandUsageText("commands.freeze.error.syntax", alias));
            return true;
        }

        Player target = TozmicMob.instance.getServer().getPlayer(args[0]);
        if (target == null) {
            sender.sendMessage(Localizer.getLocalizedText("commands.freeze.error.unknown", new String[] {"player"}, new String[] {args[0]}));
            return true;
        }

        if (FreezeListener.removeFrozenPlayer(target)) {
            target.sendMessage(Localizer.getLocalizedText("punishMessage.unfreeze"));
            sender.sendMessage(Localizer.getLocalizedText("commands.freeze.unfrozen", new String[] {"player"}, new String[] {target.getName()}));
        } else
            sender.sendMessage(Localizer.getLocalizedText("commands.freeze.none"));

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) return null;
        List<String> list = new ArrayList<String>();
        return list;
    }

}