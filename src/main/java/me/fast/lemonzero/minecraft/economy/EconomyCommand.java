 package me.fast.lemonzero.minecraft.economy;

 import javax.annotation.Nonnull;
 import me.fast.lemonzero.minecraft.utils.ChatColor;
 import org.bukkit.Bukkit;
 import org.bukkit.command.Command;
 import org.bukkit.command.CommandExecutor;
 import org.bukkit.command.CommandSender;
 import org.bukkit.entity.Player;



 public class EconomyCommand
   implements CommandExecutor
 {
   public boolean onCommand(@Nonnull CommandSender sender, @Nonnull Command command, @Nonnull String label, @Nonnull String[] args) {
     Player p = (Player)sender;
     if (p != null)
     { if (p.hasPermission("lemon.admin.economy"))
       { if (args.length == 1)
         { if (args[0].equalsIgnoreCase("help"))
           { p.sendMessage(ChatColor.cc("\n &7=== &2&lEconomy &a&lHelp &7=== \n \n/economy add <player> <double>\n/economy remove <player> <double>\n/economy set <player> <double> \n ")); }
           else { p.sendMessage(ChatColor.cc("\n &7=== &2&lEconomy &a&lHelp &7=== \n \n/economy add <player> <double>\n/economy remove <player> <double>\n/economy set <player> <double> \n ")); }  }
         else if (args.length == 3)
         { if (args[0].equalsIgnoreCase("add")) {
             if (Bukkit.getOnlinePlayers().contains(Bukkit.getPlayer(args[1]))) {
               Player p2 = Bukkit.getPlayer(args[1]);
               if (args[2].contains(".")) {
                 assert p2 != null;
                 EconomyManager.setBal(p2, Double.valueOf(EconomyManager.getBal(p2).doubleValue() + Double.parseDouble(args[2])));
                 p.sendMessage(ChatColor.cc("&2&lEconomy &8&l>> &fAdded &d" + args[2] + " &fto &b" + p2.getName() + "&f's balance. Their new balance is: &2&l$" + EconomyManager.getBal(p2)));
                 p2.sendMessage(ChatColor.cc("&2&lEconomy &8&l>> &fAdded &d" + args[2] + " &fto your balance."));
               } else {
                 p.sendMessage(ChatColor.cc("&f(&c!&f) &7Argument 3: &d" + args[2] + " &7is a invalided double. Please format the arg as a double EX: 500.0, 50.5"));
               }
             } else {
               p.sendMessage(ChatColor.cc("&f(&c!&f) &7Argument 2: &d" + args[1] + " &7is a invalided player. Please use a online player for this to work."));
             }

           } else if (args[0].equalsIgnoreCase("remove")) {
             if (Bukkit.getOnlinePlayers().contains(Bukkit.getPlayer(args[1]))) {
               Player p2 = Bukkit.getPlayer(args[1]);
               if (args[2].contains(".")) {
                 assert p2 != null;
                 EconomyManager.setBal(p2, Double.valueOf(EconomyManager.getBal(p2).doubleValue() - Double.parseDouble(args[2])));
                 p.sendMessage(ChatColor.cc("&2&lEconomy &8&l>> &fRemoved &d" + args[2] + " &ffrom &b" + p2.getName() + "&f's balance. Their new balance is: &2&l$" + EconomyManager.getBal(p2)));
                 p2.sendMessage(ChatColor.cc("&2&lEconomy &8&l>> &fRemoved &d" + args[2] + " &ffrom your balance."));
               } else {
                 p.sendMessage(ChatColor.cc("&f(&c!&f) &7Argument 3: &d" + args[2] + " &7is a invalided double. Please format the arg as a double EX: 500.0, 50.5"));
               }
             } else {
               p.sendMessage(ChatColor.cc("&f(&c!&f) &7Argument 2: &d" + args[1] + " &7is a invalided player. Please use a online player for this to work."));
             }

           } else if (args[0].equalsIgnoreCase("set")) {
             if (Bukkit.getOnlinePlayers().contains(Bukkit.getPlayer(args[1]))) {
               Player p2 = Bukkit.getPlayer(args[1]);
               if (args[2].contains(".")) {
                 assert p2 != null;
                 EconomyManager.setBal(p2, Double.valueOf(args[2]));
                 p.sendMessage(ChatColor.cc("&2&lEconomy &8&l>> &fSet &d" + p2.getName() + "&f's balance to: &b" + args[2] + ". Their new balance is: &2&l$" + EconomyManager.getBal(p2)));
                 p2.sendMessage(ChatColor.cc("&2&lEconomy &8&l>> &fSet your balance to &d" + args[2] + "&F."));
               } else {
                 p.sendMessage(ChatColor.cc("&f(&c!&f) &7Argument 3: &d" + args[2] + " &7is a invalided double. Please format the arg as a double EX: 500.0, 50.5"));
               }
             } else {
               p.sendMessage(ChatColor.cc("&f(&c!&f) &7Argument 2: &d" + args[1] + " &7is a invalided player. Please use a online player for this to work."));
             }
           } else {

             p.sendMessage(ChatColor.cc("&f(&c!&f) &7Argument 1: &d" + args[0] + " &7 is a invalided argument. Please use: add, or remove, or set for argument 1."));
           }  }
         else { p.sendMessage(ChatColor.cc("\n &7=== &2&lEconomy &a&lHelp &7=== \n \n/economy add <player> <double>\n/economy remove <player> <double>\n/economy set <player> <double> \n ")); }
          }
       else { p.sendMessage(ChatColor.cc("&f(&c!&f) &7No permissions!")); }

        }

 if (args.length == 1)
     { if (args[0].equalsIgnoreCase("help"))
       { System.out.println("\n === Economy Help === \n \n/economy add <player> <double>\n/economy remove <player> <double>\n/economy set <player> <double> \n "); }
       else
       { System.out.println("\n === Economy Help === \n \n/economy add <player> <double>\n/economy remove <player> <double>\n/economy set <player> <double> \n "); }  }
     else if (args.length == 3)
     { if (args[0].equalsIgnoreCase("add")) {
         if (Bukkit.getOnlinePlayers().contains(Bukkit.getPlayer(args[1]))) {
           Player p2 = Bukkit.getPlayer(args[1]);
           if (args[2].contains(".")) {
             assert p2 != null;
             EconomyManager.setBal(p2, Double.valueOf(EconomyManager.getBal(p2).doubleValue() + Double.parseDouble(args[2])));
             System.out.println("Economy >> &fAdded " + args[2] + " to " + p2.getName() + "'s balance. Their new balance is: $" + EconomyManager.getBal(p2));
             p2.sendMessage(ChatColor.cc("&2&lEconomy &8&l>> &fAdded &d" + args[2] + " &fto your balance."));
           } else {
             System.out.println("Argument 3: " + args[2] + " is a invalided double. Please format the arg as a double EX: 500.0, 50.5");
           }
         } else {
           System.out.println("Argument 2: " + args[1] + " is a invalided player. Please use a online player for this to work.");
         }

       } else if (args[0].equalsIgnoreCase("remove")) {
         if (Bukkit.getOnlinePlayers().contains(Bukkit.getPlayer(args[1]))) {
           Player p2 = Bukkit.getPlayer(args[1]);
           if (args[2].contains(".")) {
             assert p2 != null;
             EconomyManager.setBal(p2, Double.valueOf(EconomyManager.getBal(p2).doubleValue() - Double.parseDouble(args[2])));
             System.out.println("Economy >> &fRemoved " + args[2] + " from &b" + p2.getName() + "'s balance. Their new balance is: $" + EconomyManager.getBal(p2));
             p2.sendMessage(ChatColor.cc("&2&lEconomy &8&l>> &fRemoved &d" + args[2] + " &ffrom your balance."));
           } else {
             System.out.println("Argument 3: " + args[2] + " is a invalided double. Please format the arg as a double EX: 500.0, 50.5");
           }
         } else {
           System.out.println("Argument 2: " + args[1] + " is a invalided player. Please use a online player for this to work.");
         }

       } else if (args[0].equalsIgnoreCase("set")) {
         if (Bukkit.getOnlinePlayers().contains(Bukkit.getPlayer(args[1]))) {
           Player p2 = Bukkit.getPlayer(args[1]);
           if (args[2].contains(".")) {
             assert p2 != null;
             EconomyManager.setBal(p2, Double.valueOf(args[2]));
             System.out.println("Economy >> Set " + p2.getName() + "'s balance to: " + args[2] + ". Their new balance is: $" + EconomyManager.getBal(p2));
             p2.sendMessage(ChatColor.cc("&2&lEconomy &8&l>> &fSet your balance to &d" + args[2] + "&F."));
           } else {
             System.out.println("Argument 3: " + args[2] + " is a invalided double. Please format the arg as a double EX: 500.0, 50.5");
           }
         } else {
           System.out.println("Argument 2: " + args[1] + " is a invalided player. Please use a online player for this to work.");
         }
       } else {

         System.out.println("Argument 1: " + args[0] + " is a invalided argument. Please use: add, or remove, or set for argument 1.");
       }  }
     else { System.out.println("\n === Economy Help === \n \n/economy add <player> <double>\n/economy remove <player> <double>\n/economy set <player> <double> \n "); }




     return true;
   }
 }


