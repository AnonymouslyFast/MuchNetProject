 package me.fast.lemonzero.Minecraft.Economy;

 import javax.annotation.Nonnull;
 import me.fast.lemonzero.Minecraft.Utitites.ChatColor;
 import org.bukkit.Bukkit;
 import org.bukkit.command.Command;
 import org.bukkit.command.CommandExecutor;
 import org.bukkit.command.CommandSender;
 import org.bukkit.entity.Player;



 public class payCommand
   implements CommandExecutor
 {
   public boolean onCommand(@Nonnull CommandSender sender, @Nonnull Command command, @Nonnull String label, @Nonnull String[] args) {
     if (sender instanceof Player)
     { if (args.length == 2) {
         Player p = (Player)sender;
         Player p2 = Bukkit.getPlayerExact(args[0]);
         if (p2 != null) {
           if (args[1].contains(".")) {
             EconomyManager.setBal(p, Double.valueOf(EconomyManager.getBal(p).doubleValue() - Double.parseDouble(args[1])));
             EconomyManager.setBal(p2, Double.valueOf(EconomyManager.getBal(p2).doubleValue() + Double.parseDouble(args[1])));
             p.sendMessage(ChatColor.cc("&aPaid &d" + p2.getName() + " &2$&f" + args[1]));
             p2.sendMessage(ChatColor.cc("&d" + p.getName() + " &apaid you &2$&f" + args[1]));
           } else {
             p.sendMessage(ChatColor.cc("&f(&c!&f) &7Argument 2: &d" + args[1] + " &7is not a double. Please use a valid double EX: 50.5, 10.0"));
           }
         } else {
           p.sendMessage(ChatColor.cc("&f(&c!&f) &7Argument 1: &d" + args[0] + " &7is not a online player. Please verify that arg-1 is a valid online player."));
         }
       }  }
     else { sender.sendMessage(command.getUsage()); }

     return true;
   }
 }


