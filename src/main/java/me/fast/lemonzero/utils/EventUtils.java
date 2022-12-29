package me.fast.lemonzero.utils;

import me.fast.lemonzero.LemonZero;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;

public class EventUtils {

    public static void registerMinecraftListeners() {
        for (Class<?> c : new Reflections(LemonZero.getPlugin().getClass().getPackageName() + ".listeners.minecraft").getSubTypesOf(Listener.class)) {
            try {
                Listener listener = (Listener) c
                        .getDeclaredConstructor()
                        .newInstance();
                LemonZero.getPlugin().getServer().getPluginManager().registerEvents(listener, LemonZero.getPlugin());
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        MessageUtils.log("&aSuccessfully registered &eLemonZero &aMinecraft listeners.");
    }

    public static void registerDiscordListeners() {
        for (Class<?> c : new Reflections(LemonZero.getPlugin().getClass().getPackageName() + ".listeners.minecraft").getSubTypesOf(Listener.class)) {
            try {
                ListenerAdapter listener = (ListenerAdapter) c
                        .getDeclaredConstructor()
                        .newInstance();
                LemonZero.jda.addEventListener(listener);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        MessageUtils.log("&aSuccessfully registered &eLemonZero &aDiscord listeners.");
    }
}
