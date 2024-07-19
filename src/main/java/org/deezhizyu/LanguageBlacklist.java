package org.deezhizyu;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class LanguageBlacklist extends JavaPlugin {
    private static LanguageBlacklist instance;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);

        instance = this;
    }

    public static LanguageBlacklist getPlugin() {
        return instance;
    }
}
