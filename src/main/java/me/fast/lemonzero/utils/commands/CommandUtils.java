package me.fast.lemonzero.utils.commands;

import me.fast.lemonzero.LemonZero;
import me.fast.lemonzero.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.command.defaults.BukkitCommand;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class CommandUtils {

    private static final List<SelfRegisteringCommand> commands = new ArrayList<>();

    public static void registerCommands() {
        for (Class<?> c : new Reflections(LemonZero.getPlugin().getClass().getPackageName() + ".commands").getSubTypesOf(CommandInterface.class)) {
            try {
                c.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            final Field bukkitCommandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            bukkitCommandMap.setAccessible(true);

            CommandMap commandMap = (CommandMap) bukkitCommandMap.get(Bukkit.getServer());
            for (BukkitCommand command : commands) {
                commandMap.register("LemonZero", command);
            }

            MessageUtils.log("&aSuccessfully registered &eLemonZero&a commands.");
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtils.log("&cAn error occurred while registering &eLemonZero&c commands.");
        }
    }

    public static void add(SelfRegisteringCommand command) {
        commands.add(command);
    }
}
