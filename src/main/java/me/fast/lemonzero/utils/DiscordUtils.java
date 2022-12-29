package me.fast.lemonzero.utils;

import me.fast.lemonzero.LemonZero;

public class DiscordUtils {

    public static void log(String message) {
        if (isEnabled())
            LemonZero.logChat.sendMessage(message).queue();
    }

    public static boolean isEnabled() {
        return LemonZero.hasJDA;
    }

    public interface Interface {

    }
}
