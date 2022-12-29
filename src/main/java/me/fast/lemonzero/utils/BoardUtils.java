package me.fast.lemonzero.utils;

import me.fast.lemonzero.board.reflection.FastBoard;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class BoardUtils {

    private static final HashMap<Player, FastBoard> sidebarBoards = new HashMap<>();

    public static boolean hasSidebar(Player player) {
        return sidebarBoards.containsKey(player);
    }

    public static void createSidebar(Player player) {
        if (!hasSidebar(player))
            sidebarBoards.put(player, new FastBoard(player));
    }

    public static FastBoard getSidebar(Player player) {
        return sidebarBoards.get(player);
    }

    public static void deleteSidebar(Player player) {
        if (hasSidebar(player)) {
            getSidebar(player).delete();
            sidebarBoards.remove(player);
        }
    }

    public static void setSidebarTitle(Player player, String title) {
        if (hasSidebar(player)) {
            getSidebar(player).updateTitle(ChatColor.translateAlternateColorCodes('&', title));
        }
    }

    public static void setSidebarLine(Player player, String text, int line) {
        if (hasSidebar(player)) {
            getSidebar(player).updateLine(line, ChatColor.translateAlternateColorCodes('&', text));
        }
    }
}
