package com.tozmic.tozmicmob;

import com.tozmic.tozmicmob.commands.author;
import com.tozmic.tozmicmob.commands.turtle;
import com.tozmic.tozmicmob.listeners.SpawnMob;
import org.bukkit.plugin.java.JavaPlugin;


//freeze stuff

import com.tozmic.tozmicmob.commands.unfreeze;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LogEvent;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.java.JavaPlugin;
import com.tozmic.tozmicmob.listeners.FreezeListener;
import com.tozmic.tozmicmob.utils.text.Colorizer;
import com.tozmic.tozmicmob.utils.text.Localizer;
import com.tozmic.tozmicmob.commands.freeze;




public final class TozmicMob extends JavaPlugin {
    public static TozmicMob instance = null;
    public static Logger LOGGER = LogManager.getLogger("TozmicFreeze");

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();
        initTextUtils();

        registerEvents();
        registerCommands();

        this.getServer().getPluginManager().registerEvents(new SpawnMob(), this);
        //NMSUtils.registerEntity("tozmic_bear", MobType.POLAR_BEAR, PolarMain.class, false);
        this.getCommand("tozmicmob").setExecutor(new author());
        this.getCommand("turtle").setExecutor(new turtle());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    private void initTextUtils() {
        // Text colorization/stylization
        ConfigurationSection styleSection = getConfig().getConfigurationSection("tozmic.style");
        if (styleSection != null) {
            String styleCharStr = styleSection.getString("stylechar", "");
            String hexColorMarker = styleSection.getString("hexcolor", "");
            if (styleCharStr.trim().length() == 1 && !hexColorMarker.trim().isEmpty())
                Colorizer.setStyleChars(styleCharStr.charAt(0), hexColorMarker);
            else
                logWarning("Ignore this message for now!");
        } else
            logWarning("Ignore this message for now!");
        // Text localization
        ConfigurationSection localizationSection = getConfig().getConfigurationSection("tozmic.placeholders");
        if (localizationSection != null) {
            String beginning = localizationSection.getString("inital","");
            String ending = localizationSection.getString("final","");
            if (!beginning.trim().isEmpty() && !ending.trim().isEmpty())
                Localizer.setSubstitutionDelimiters(beginning, ending);
            else
                logWarning("Ignore this message for now!");
        } else
            logWarning("Ignore this message for now!");
    }


    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new FreezeListener(), this);
    }

    public void registerCommands() {
        String permissionMessage = Localizer.getLocalizedText("noPermission");
        registerCommand("freeze", new freeze(), permissionMessage);
        registerCommand("unfreeze", new unfreeze(), permissionMessage);
    }

    public void registerCommand(String name, CommandExecutor executor, String permissionMessage) {
        PluginCommand cmd = getServer().getPluginCommand(name);
        cmd.setExecutor(executor);
        cmd.setPermissionMessage(permissionMessage);
    }

    public static void logInfo(String text) {
        LOGGER.log(Level.INFO, text);
    }
    private void logWarning(String text) {
        LOGGER.log(Level.WARN, text);
    }
}



