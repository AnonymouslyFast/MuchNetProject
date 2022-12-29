package me.fast.lemonzero.listeners.minecraft;

import me.fast.lemonzero.utils.DiscordUtils;
import net.dv8tion.jda.api.utils.TimeFormat;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandListener implements Listener {

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        DiscordUtils.log("**LemonZero** - " + TimeFormat.TIME_LONG.now() + " " + event.getPlayer().getName() + " Executed `" + event.getMessage() + "`");
    }
}
