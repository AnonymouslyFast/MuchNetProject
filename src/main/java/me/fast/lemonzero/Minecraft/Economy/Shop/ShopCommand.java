 package me.fast.lemonzero.Minecraft.Economy.Shop;

 import me.fast.lemonzero.Minecraft.Economy.Shop.Inventories.MainShop;
 import me.fast.lemonzero.Minecraft.Utitites.ChatColor;
 import org.bukkit.Bukkit;
 import org.bukkit.command.Command;
 import org.bukkit.command.CommandExecutor;
 import org.bukkit.command.CommandSender;
 import org.bukkit.entity.Player;
 import org.bukkit.inventory.Inventory;

 import org.jetbrains.annotations.NotNull;



 public class ShopCommand
   implements CommandExecutor
 {
   public static Inventory shop;

   public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
     if (sender instanceof Player) { Player p = (Player)sender;
       shop = Bukkit.createInventory(p, 36, ChatColor.cc("&e&lShop"));
       MainShop.openShop(p); }




     return true;
   }
 }


