package org.deezhizyu;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Date;
import java.util.List;

public class JoinEvent implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        LanguageBlacklist plugin = LanguageBlacklist.getPlugin();
        List<?> blacklistedLanguages = plugin.getConfig().getList("blacklist");

        if (blacklistedLanguages == null) {
            return;
        }

        if (blacklistedLanguages.contains(player.locale().toString().toLowerCase())) {
            Bukkit.getScheduler().runTask(plugin, () -> {
                String message = plugin.getConfig().getString("message");

                if (message == null) {
                    message = "Your language settings is not allowed.";
                }

                boolean shouldBan = plugin.getConfig().getBoolean("shouldBan");

                if (shouldBan) {
                    event.getPlayer().ban(message, (Date) null, "");
                } else {
                    event.getPlayer().kick(Component.text(message));
                }
            });
        }
    }
}
