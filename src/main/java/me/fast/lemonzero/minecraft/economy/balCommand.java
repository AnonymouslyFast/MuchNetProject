 package me.fast.lemonzero.minecraft.economy;

 import javax.annotation.Nonnull;
import me.fast.lemonzero.minecraft.utils.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class balCommand
  implements CommandExecutor
 {
  public boolean onCommand(@Nonnull CommandSender sender, @Nonnull Command command, @Nonnull String label, @Nonnull String[] args) {
      if (sender instanceof Player) {
          Player p = (Player) sender;
          if (args.length == 0) {
              p.sendMessage(ChatColor.cc("&2Your balance is: &2&l$&f" + EconomyManager.getBal(p)));
          } else {
              Player player = Bukkit.getPlayerExact(args[0]);
              if (player == null) {
                  p.sendMessage(ChatColor.cc("&f(&c!&f) &7That player has never joined before!"));
                  return true;
              }
              p.sendMessage(ChatColor.cc("&2" + player.getName() + "'s balance is: &2&l$&f" + EconomyManager.getBal(player)));
          }
      }


    return true;
}}
