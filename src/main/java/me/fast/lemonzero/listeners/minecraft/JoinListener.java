package me.fast.lemonzero.listeners.minecraft;

import me.fast.lemonzero.LemonZero;
import me.fast.lemonzero.utils.DiscordUtils;
import me.fast.lemonzero.utils.Rank;
import me.fast.lemonzero.utils.board.BoardUtils;
import me.fast.lemonzero.utils.MessageUtils;
import me.fast.lemonzero.utils.data.DataManager;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.MessageEmbed;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.awt.*;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        DataManager.loadData(player);
        if (!DataManager.hasFile(player)) {
            MessageUtils.send(player, "&7&lSystem &8&l>> &fWelcome " + player.getName() + " to &e&lLemon&6&lZero&f!", "", "&6Welcome Rewards", "&8- &a$&f250", "&8- &f100 &eLemons");
            DataManager.setBalance(player, 250);
            DataManager.setGroup(player, Rank.DEFAULT);
        }

        BoardUtils.createSidebar(player);
        BoardUtils.setSidebarTitle(player, "&e&lLemon&6&lZero");
        BoardUtils.setSidebarLines(player, "&aLine 0", "&bLine 1", "&eLine 2", "&d" + DataManager.getGroup(player), "&c" + DataManager.getBalance(player));

        if (DiscordUtils.isEnabled()) {
            if (player.hasPlayedBefore()) {
                EmbedBuilder builder = (new EmbedBuilder()).setColor(Color.green).setAuthor(ChatColor.stripColor(DataManager.getGroup(player).getDisplay() + " | " + player.getDisplayName()) + " Joined!", null, "https://crafatar.com/avatars/" + player.getUniqueId() + "?overlay=1");
                LemonZero.mcChat.sendMessageEmbeds(builder.build(), new MessageEmbed[0]).queue();
            } else {
                EmbedBuilder builder = (new EmbedBuilder()).setColor(Color.YELLOW).setAuthor(ChatColor.stripColor(DataManager.getGroup(player).getDisplay() + " | " + player.getDisplayName()) + " Joined for the First Time!", null, "https://crafatar.com/avatars/" + player.getUniqueId() + "?overlay=1");
                LemonZero.mcChat.sendMessageEmbeds(builder.build(), new MessageEmbed[0]).queue();
            }
            LemonZero.jda.getPresence().setActivity(Activity.playing("LemonZero.minehut.gg: " + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers()));
        }
    }
}
