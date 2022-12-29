package me.fast.lemonzero.commands;

import me.fast.lemonzero.utils.MessageUtils;
import me.fast.lemonzero.utils.commands.CommandInterface;
import me.fast.lemonzero.utils.commands.SelfRegisteringCommand;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GameModeCMD implements CommandInterface {

    static {
        new SelfRegisteringCommand("gmc", "Game mode commands!", "usages", List.of("gms", "gma", "gmsp")) {

            @Override
            public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
                if (args.length > 0) {
                    if (Bukkit.getPlayer(args[0]) != null) {
                        Player victim = Bukkit.getPlayer(args[0]);
                        switch (commandLabel) {
                            case ("gmc") -> victim.setGameMode(GameMode.CREATIVE);
                            case ("gms") -> victim.setGameMode(GameMode.SURVIVAL);
                            case ("gma") -> victim.setGameMode(GameMode.ADVENTURE);
                            case ("gmsp") -> victim.setGameMode(GameMode.SPECTATOR);
                        }
                        MessageUtils.send(sender, "Set " + victim.getName() + "'s game mode to " + victim.getGameMode().name().toLowerCase());
                    }
                } else {
                    if (sender instanceof Player player) {
                        switch (commandLabel) {
                            case ("gmc") -> player.setGameMode(GameMode.CREATIVE);
                            case ("gms") -> player.setGameMode(GameMode.SURVIVAL);
                            case ("gma") -> player.setGameMode(GameMode.ADVENTURE);
                            case ("gmsp") -> player.setGameMode(GameMode.SPECTATOR);
                        }
                        MessageUtils.send(player, "Set game mode to " + player.getGameMode().name().toLowerCase());
                    }
                }
                return true;
            }
        };
    }
}
