package me.fast.lemonzero.Discord.Verify;

import java.util.HashMap;
import java.util.UUID;
import me.fast.lemonzero.LemonZero;
import me.fast.lemonzero.Minecraft.Utitites.ChatColor;
import net.dv8tion.jda.api.entities.Member;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class MinecraftCommand implements CommandExecutor {
  public static HashMap<Player, Integer> verifynum = new HashMap<>();
  
  public static HashMap<UUID, Member> verifyedAsUUID = new HashMap<>();
  
  public static HashMap<Member, UUID> verifyedAsMember = new HashMap<>();
  
  public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
    if (sender instanceof Player) {
      Player p = (Player)sender;
      if (!verifyedAsUUID.containsKey(p.getUniqueId())) {
        int code = (int)(Math.random() * 500.0D + 1.0D);
        verifynum.put(p, Integer.valueOf(code));
        p.sendMessage(ChatColor.cc("&7[&6&lL&e&lZ&7] &fYour code to verify is: &c" + code + "&f. Your verification code will expire in 1 minute!"));
        Bukkit.getScheduler().runTaskLater((Plugin)LemonZero.getPlugin(), () -> verifynum.remove(p), 1200L);
        Bukkit.getScheduler().runTaskLater((Plugin)LemonZero.getPlugin(), () -> p.sendMessage(ChatColor.cc("&7[&6&lL&e&lZ&7] &fYour verification code expired!")), 1200L);
      } else {
        p.sendMessage(ChatColor.cc("&7[&6&lL&e&LZ&7] &fYou're already verified!"));
      } 
    } else {
      System.out.println("Get on!");
    } 
    return true;
  }
}