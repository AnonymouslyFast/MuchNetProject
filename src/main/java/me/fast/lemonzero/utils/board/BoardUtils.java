package me.fast.lemonzero.utils.board;

import me.fast.lemonzero.utils.MessageUtils;
import me.fast.lemonzero.utils.board.reflection.FastBoard;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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

    public static void setSidebarLines(Player player, String... texts) {
        if (hasSidebar(player)) {
            List<String> lines = Arrays.asList(texts);
            for (int i = 0; i < lines.size(); i++)
                getSidebar(player).updateLine(i, MessageUtils.translate(lines.get(i)));
        }
    }
}
