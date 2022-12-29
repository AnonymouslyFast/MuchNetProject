package me.fast.lemonzero.utils.commands;

import org.bukkit.command.defaults.BukkitCommand;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public abstract class SelfRegisteringCommand extends BukkitCommand {


    protected SelfRegisteringCommand(@NotNull String name) {
        super(name);
        CommandUtils.add(this);
    }

    protected SelfRegisteringCommand(@NotNull String name, @NotNull String description, @NotNull String usageMessage, @NotNull List<String> aliases) {
        super(name, description, usageMessage, aliases);
        CommandUtils.add(this);
    }
}
